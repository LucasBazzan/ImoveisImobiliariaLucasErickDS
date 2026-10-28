package Controller;

import DAO.ImovelDAO;
import Model.ImovelModel;
import java.sql.SQLException;
import java.util.List;

public class ImovelController {
    private final ImovelDAO dao = new ImovelDAO();

    private void validar(ImovelModel imovel) {
        if (imovel.getIDImobiliaria() <= 0)
            throw new IllegalArgumentException("Selecione uma imobiliária válida.");
        if (imovel.getTipo() == null || imovel.getTipo().isBlank() || imovel.getTipo().length() > 25)
            throw new IllegalArgumentException("Tipo obrigatório (até 25 caracteres).");
        if (imovel.getBairro() == null || imovel.getBairro().isBlank() || imovel.getBairro().length() > 20)
            throw new IllegalArgumentException("Bairro obrigatório (até 20 caracteres).");
        if (imovel.getDescricao() == null || imovel.getDescricao().isBlank())
            throw new IllegalArgumentException("Informe a descrição do imóvel.");
        if (!Float.isFinite(imovel.getValor()) || imovel.getValor() <= 0)
            throw new IllegalArgumentException("O valor deve ser positivo.");
        if (imovel.getFoto() == null || imovel.getFoto().length() > 45)
            throw new IllegalArgumentException("Nome da foto inválido (até 45 caracteres).");
        if (imovel.getSituacao() == null || imovel.getSituacao().isBlank() || imovel.getSituacao().length() > 15)
            throw new IllegalArgumentException("Situação obrigatória (até 15 caracteres).");
    }

    public int cadastrar(ImovelModel imovel) throws SQLException {
        validar(imovel);
        return dao.inserir(imovel);
    }

    public boolean atualizar(ImovelModel imovel) throws SQLException {
        if (imovel.getID() <= 0) throw new IllegalArgumentException("Selecione um imóvel.");
        validar(imovel);
        return dao.atualizar(imovel);
    }

    public boolean excluir(int id) throws SQLException {
        if (id <= 0) throw new IllegalArgumentException("Selecione um imóvel.");
        return dao.excluir(id);
    }

    public ImovelModel buscarPorId(int id) throws SQLException { return dao.buscarPorId(id); }
    public List<ImovelModel> listar() throws SQLException { return dao.listar(); }
}
