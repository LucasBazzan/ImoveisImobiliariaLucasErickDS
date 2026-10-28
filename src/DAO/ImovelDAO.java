package DAO;

import Model.DatabaseConnection;
import Model.ImovelModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {
    private final DatabaseConnection database = new DatabaseConnection();

    private ImovelModel converter(ResultSet rs) throws SQLException {
        ImovelModel imovel = new ImovelModel();
        imovel.setID(rs.getInt("ID"));
        imovel.setDescricao(rs.getString("Descricao"));
        imovel.setIDImobiliaria(rs.getInt("IDImobiliaria"));
        imovel.setTipo(rs.getString("Tipo"));
        imovel.setValor(rs.getFloat("Valor"));
        imovel.setBairro(rs.getString("Bairro"));
        imovel.setFoto(rs.getString("Foto"));
        imovel.setSituacao(rs.getString("Situacao"));
        return imovel;
    }

    public List<ImovelModel> listar() throws SQLException {
        String sql = "SELECT ID, Descricao, IDImobiliaria, Tipo, Valor, Bairro, Foto, Situacao "
                   + "FROM imoveis ORDER BY ID DESC";
        List<ImovelModel> lista = new ArrayList<>();
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(converter(rs));
        }
        return lista;
    }

    public ImovelModel buscarPorId(int id) throws SQLException {
        String sql = "SELECT ID, Descricao, IDImobiliaria, Tipo, Valor, Bairro, Foto, Situacao "
                   + "FROM imoveis WHERE ID = ?";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? converter(rs) : null;
            }
        }
    }

    private void parametros(PreparedStatement ps, ImovelModel imovel) throws SQLException {
        ps.setString(1, imovel.getDescricao());
        ps.setInt(2, imovel.getIDImobiliaria());
        ps.setString(3, imovel.getTipo());
        ps.setFloat(4, imovel.getValor());
        ps.setString(5, imovel.getBairro());
        ps.setString(6, imovel.getFoto());
        ps.setString(7, imovel.getSituacao());
    }

    public int inserir(ImovelModel imovel) throws SQLException {
        String sql = "INSERT INTO imoveis (Descricao, IDImobiliaria, Tipo, Valor, Bairro, Foto, Situacao) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            parametros(ps, imovel);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        throw new SQLException("Não foi possível recuperar o ID do imóvel cadastrado.");
    }

    public boolean atualizar(ImovelModel imovel) throws SQLException {
        String sql = "UPDATE imoveis SET Descricao = ?, IDImobiliaria = ?, Tipo = ?, "
                   + "Valor = ?, Bairro = ?, Foto = ?, Situacao = ? WHERE ID = ?";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            parametros(ps, imovel);
            ps.setInt(8, imovel.getID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM imoveis WHERE ID = ?";
        try (Connection conn = database.Connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
