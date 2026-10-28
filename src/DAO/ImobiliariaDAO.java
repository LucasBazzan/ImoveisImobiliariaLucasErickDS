package DAO;

import Model.DatabaseConnection;
import Model.ImobiliariasModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDAO {
    private final DatabaseConnection database = new DatabaseConnection();

    private ImobiliariasModel converter(ResultSet rs) throws SQLException {
        ImobiliariasModel imobiliaria = new ImobiliariasModel();
        imobiliaria.setID(rs.getInt("ID"));
        imobiliaria.setNome(rs.getString("Nome"));
        imobiliaria.setTelefone(rs.getString("Telefone"));
        imobiliaria.setContato(rs.getString("Contato"));
        return imobiliaria;
    }

    public List<ImobiliariasModel> listar() throws SQLException {
        String sql = "SELECT ID, Nome, Telefone, Contato FROM imobiliarias ORDER BY Nome, ID";
        List<ImobiliariasModel> lista = new ArrayList<>();
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(converter(rs));
        }
        return lista;
    }

    public ImobiliariasModel buscarPorId(int id) throws SQLException {
        String sql = "SELECT ID, Nome, Telefone, Contato FROM imobiliarias WHERE ID = ?";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? converter(rs) : null;
            }
        }
    }

    public int inserir(ImobiliariasModel imobiliaria) throws SQLException {
        String sql = "INSERT INTO imobiliarias (Nome, Telefone, Contato) VALUES (?, ?, ?)";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, imobiliaria.getNome());
            ps.setString(2, imobiliaria.getTelefone());
            ps.setString(3, imobiliaria.getContato());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        throw new SQLException("Não foi possível recuperar o ID da imobiliária cadastrada.");
    }

    public boolean atualizar(ImobiliariasModel imobiliaria) throws SQLException {
        String sql = "UPDATE imobiliarias SET Nome = ?, Telefone = ?, Contato = ? WHERE ID = ?";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, imobiliaria.getNome());
            ps.setString(2, imobiliaria.getTelefone());
            ps.setString(3, imobiliaria.getContato());
            ps.setInt(4, imobiliaria.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException {
        // Impede apagar a imobiliária enquanto ela possui imóveis vinculados.
        String verificar = "SELECT COUNT(*) FROM imoveis WHERE IDImobiliaria = ?";
        String excluir = "DELETE FROM imobiliarias WHERE ID = ?";
        try (Connection conn = database.Connect()) {
            try (PreparedStatement ps = conn.prepareStatement(verificar)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        throw new IllegalStateException(
                            "Esta imobiliária possui imóveis cadastrados. Exclua ou transfira os imóveis primeiro.");
                    }
                }
            }
            try (PreparedStatement ps = conn.prepareStatement(excluir)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        }
    }
}
