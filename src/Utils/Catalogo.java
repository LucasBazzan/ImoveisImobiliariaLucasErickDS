package Utils;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public final class Catalogo {
    private Catalogo() { }

    /** Retorna o ID da primeira coluna selecionada, ou 0 ao cancelar. */
    public static int selecionar(Component pai, String titulo, String[] colunas, Object[][] linhas) {
        if (linhas.length == 0) {
            JOptionPane.showMessageDialog(pai, "Nenhum registro encontrado.");
            return 0;
        }
        DefaultTableModel modelo = new DefaultTableModel(linhas, colunas) {
            @Override public boolean isCellEditable(int linha, int coluna) { return false; }
        };
        JTable tabela = new JTable(modelo);
        tabela.setAutoCreateRowSorter(true);
        tabela.setRowHeight(26);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().setSelectionInterval(0, 0);
        JScrollPane rolagem = new JScrollPane(tabela);
        rolagem.setPreferredSize(new Dimension(810, 360));

        int resposta = JOptionPane.showConfirmDialog(pai, rolagem,
                titulo + " — selecione o registro", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (resposta != JOptionPane.OK_OPTION || tabela.getSelectedRow() < 0) return 0;
        int indiceModelo = tabela.convertRowIndexToModel(tabela.getSelectedRow());
        return ((Number) modelo.getValueAt(indiceModelo, 0)).intValue();
    }
}
