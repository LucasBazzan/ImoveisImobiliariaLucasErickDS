package Controller;

import DAO.ImobiliariaDAO;
import Model.ImobiliariasModel;
import java.sql.SQLException;
import java.util.List;

public class ImobiliariaController {
    private final ImobiliariaDAO dao = new ImobiliariaDAO();

    private void validar(ImobiliariasModel imob) {
        if (imob.getNome() == null || imob.getNome().isBlank() || imob.getNome().length() > 45)
            throw new IllegalArgumentException("Nome obrigatório (até 45 caracteres).");
        if (imob.getTelefone() == null || imob.getTelefone().isBlank() || imob.getTelefone().length() > 45)
            throw new IllegalArgumentException("Telefone obrigatório (até 45 caracteres).");
        if (imob.getContato() == null || imob.getContato().isBlank() || imob.getContato().length() > 45)
            throw new IllegalArgumentException("Contato obrigatório (até 45 caracteres).");
    }

    public int cadastrar(ImobiliariasModel imob) throws SQLException {
        validar(imob);
        return dao.inserir(imob);
    }

    public boolean atualizar(ImobiliariasModel imob) throws SQLException {
        if (imob.getID() <= 0) throw new IllegalArgumentException("Selecione uma imobiliária.");
        validar(imob);
        return dao.atualizar(imob);
    }

    public boolean excluir(int id) throws SQLException {
        if (id <= 0) throw new IllegalArgumentException("Selecione uma imobiliária.");
        return dao.excluir(id);
    }

    public ImobiliariasModel buscarPorId(int id) throws SQLException { return dao.buscarPorId(id); }
    public List<ImobiliariasModel> listar() throws SQLException { return dao.listar(); }
}
