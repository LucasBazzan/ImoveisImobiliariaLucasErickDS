/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Utils.Cores;
import Utils.EstiloBotao;
import Utils.Catalogo;
import Utils.FotoUtils;
import Controller.ImobiliariaController;
import Controller.ImovelController;
import Model.ImobiliariasModel;
import Model.ImovelModel;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.pushingpixels.radiance.theming.api.RadianceThemingCortex;
import org.pushingpixels.radiance.theming.api.RadianceThemingSlices.FocusKind;

public class ImovelView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ImovelView.class.getName());
    private final ImovelController controller = new ImovelController();
    private final ImobiliariaController imobiliariaController = new ImobiliariaController();
    private final Map<Integer, String> nomesImobiliarias = new HashMap<>();
    private int idSelecionado = 0;
    private String fotoAtual = "";
    private String situacaoAtual = "Disponível";
    private File imagemSelecionada = null;

    /**
     * Creates new form ImovelView
     */
    public ImovelView() {
        initComponents();
    
        EstiloBotao.aplicar(btnInserirImagem, Cores.LIGHT_BLUE);
        EstiloBotao.aplicar(btnCadastrar, Cores.GREEN);
        EstiloBotao.aplicar(btnExcluir, Cores.RED);
        EstiloBotao.aplicar(btnLimpar, Cores.GRAY);
        EstiloBotao.aplicar(btnConsultar, Cores.SKY_BLUE);
        EstiloBotao.aplicar(btnAtualizar, Cores.GOLD);
        EstiloBotao.aplicar(btnIrParaImoveis, Cores.GRAY);
        btnCadastrar.addActionListener(e -> cadastrar());
        btnConsultar.addActionListener(e -> consultar());
        btnAtualizar.addActionListener(e -> atualizar());
        btnExcluir.addActionListener(e -> excluir());
        btnLimpar.addActionListener(e -> limpar());
        carregarImobiliarias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnIrParaImoveis = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnInserirImagem = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        cbListarImobiliarias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setFocusable(false);

        jLabel1.setBackground(new java.awt.Color(67, 67, 67));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 36)); // NOI18N
        jLabel1.setText("Wellersons | Imóveis");
        jLabel1.setFocusable(false);

        btnIrParaImoveis.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnIrParaImoveis.setText("Ir para Imobiliárias");
        btnIrParaImoveis.setFocusPainted(false);
        btnIrParaImoveis.setFocusable(false);
        btnIrParaImoveis.addActionListener(this::btnIrParaImoveisActionPerformed);

        jPanel1.setFocusable(false);

        btnConsultar.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        btnConsultar.setText("Consultar Catálogo");

        btnCadastrar.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar");

        btnLimpar.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar ");

        btnExcluir.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir ");

        btnAtualizar.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar Catálogo");

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel5.setText("Dados dos Imóveis");

        txtTipo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtTipo.setText("Digite o tipo");
        txtTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTipoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tipo do imóvel");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Bairro");

        txtBairro.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtBairro.setText("Bairro do imóvel");
        txtBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBairroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBairroFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Valor");

        txtValor.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtValor.setText("Valor do imóvel (R$)");
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Descrição");

        btnInserirImagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInserirImagem.setText("Inserir Imagem");
        btnInserirImagem.addActionListener(this::btnInserirImagemActionPerformed);

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagem.setPreferredSize(new java.awt.Dimension(367, 210));

        cbListarImobiliarias.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(202, 202, 202)
                                .addComponent(jLabel3)
                                .addGap(368, 368, 368))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(165, 165, 165)
                                            .addComponent(jLabel4)
                                            .addGap(504, 504, 504)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtValor)
                                            .addComponent(cbListarImobiliarias, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btnInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbListarImobiliarias, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(503, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIrParaImoveis, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrParaImoveis, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(428, 428, 428))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirImagemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecionar imagem");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("Imagens (PNG, JPG, JPEG)", "png", "jpg", "jpeg"));
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        try {
            mostrarFoto(chooser.getSelectedFile());
            imagemSelecionada = chooser.getSelectedFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de imagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirImagemActionPerformed

    private void btnIrParaImoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrParaImoveisActionPerformed
        ImobiliariaView imobiliariaView = new ImobiliariaView();
        imobiliariaView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIrParaImoveisActionPerformed

    private void txtTipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoFocusGained
        if (txtTipo.getText().equals("Digite o tipo")) 
            txtTipo.setText("");
    }//GEN-LAST:event_txtTipoFocusGained
    private void txtTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoFocusLost
        if (txtTipo.getText().isEmpty()) 
            txtTipo.setText("Digite o tipo");
    }//GEN-LAST:event_txtTipoFocusLost

    private void txtBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusGained
        if (txtBairro.getText().equals("Bairro do imóvel")) 
            txtBairro.setText("");   
    }//GEN-LAST:event_txtBairroFocusGained
    private void txtBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusLost
        if (txtBairro.getText().isEmpty()) 
            txtBairro.setText("Bairro do imóvel");  
    }//GEN-LAST:event_txtBairroFocusLost

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        if (txtValor.getText().equals("Valor do imóvel (R$)"))
            txtValor.setText("");
    }//GEN-LAST:event_txtValorFocusGained

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        if (txtValor.getText().isEmpty())
            txtValor.setText("Valor do imóvel (R$)");

    }//GEN-LAST:event_txtValorFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        RadianceThemingCortex.ComponentOrParentChainScope.setFocusKind(cbListarImobiliarias, FocusKind.NONE);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    // Implementação do CRUD (fora do trecho gerado pelo NetBeans).
    private void mostrarErro(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void carregarImobiliarias() {
        try {
            List<ImobiliariasModel> lista = imobiliariaController.listar();
            DefaultComboBoxModel<String> combo = new DefaultComboBoxModel<>();
            nomesImobiliarias.clear();
            for (ImobiliariasModel imob : lista) {
                nomesImobiliarias.put(imob.getID(), imob.getNome());
                combo.addElement(imob.getID() + " - " + imob.getNome());
            }
            cbListarImobiliarias.setModel(combo);
        } catch (SQLException e) { mostrarErro(e); }
    }

    private int obterIdImobiliaria() {
        Object selecionado = cbListarImobiliarias.getSelectedItem();
        if (selecionado == null) return 0;
        String item = selecionado.toString();
        int separador = item.indexOf(" - ");
        return separador > 0 ? Integer.parseInt(item.substring(0, separador)) : 0;
    }

    private void selecionarImobiliaria(int id) {
        for (int i = 0; i < cbListarImobiliarias.getItemCount(); i++) {
            String item = cbListarImobiliarias.getItemAt(i);
            if (item.startsWith(id + " - ")) {
                cbListarImobiliarias.setSelectedIndex(i);
                return;
            }
        }
        cbListarImobiliarias.setSelectedIndex(-1);
    }

    private String lerCampo(javax.swing.JTextField campo, String placeholder) {
        String valor = campo.getText().trim();
        return valor.equals(placeholder) ? "" : valor;
    }

    private float obterValor() {
        String valor = lerCampo(txtValor, "Valor do imóvel (R$)")
                .replace("R$", "").replace(" ", "");
        if (valor.contains(",")) valor = valor.replace(".", "").replace(",", ".");
        try { return Float.parseFloat(valor); }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor inválido. Exemplo: 350.000,50");
        }
    }

    private ImovelModel dadosDoFormulario(String nomeFoto, String situacao) {
        ImovelModel imovel = new ImovelModel();
        imovel.setID(idSelecionado);
        imovel.setIDImobiliaria(obterIdImobiliaria());
        imovel.setTipo(lerCampo(txtTipo, "Digite o tipo"));
        imovel.setBairro(lerCampo(txtBairro, "Bairro do imóvel"));
        imovel.setValor(obterValor());
        imovel.setDescricao(txtDescricao.getText().trim());
        imovel.setFoto(nomeFoto);
        imovel.setSituacao(situacao.trim());
        return imovel;
    }

    private String perguntarSituacao() {
        return JOptionPane.showInputDialog(this,
                "Situação do imóvel (ex.: Disponível, Reservado, Vendido, Alugado):",
                situacaoAtual);
    }

    private void mostrarFoto(File arquivo) throws IOException {
        if (arquivo == null || !arquivo.isFile()) throw new IOException("Foto não encontrada.");
        BufferedImage imagem = ImageIO.read(arquivo);
        if (imagem == null) throw new IOException("Arquivo de imagem inválido.");
        Insets borda = lblImagem.getInsets();
        int largura = lblImagem.getWidth() - borda.left - borda.right;
        int altura = lblImagem.getHeight() - borda.top - borda.bottom;
        if (largura <= 0 || altura <= 0) {
            largura = 367;
            altura = 210;
        }
        double escala = Math.max((double) largura / imagem.getWidth(), (double) altura / imagem.getHeight());
        int novaLargura = (int) Math.ceil(imagem.getWidth() * escala);
        int novaAltura = (int) Math.ceil(imagem.getHeight() * escala);
        BufferedImage preview = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = preview.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawImage(imagem, (largura - novaLargura) / 2, (altura - novaAltura) / 2,
                    novaLargura, novaAltura, null);
        g.dispose();
        lblImagem.setIcon(new ImageIcon(preview));
        lblImagem.setText("");
    }

    private void limpar() {
        idSelecionado = 0;
        fotoAtual = "";
        situacaoAtual = "Disponível";
        imagemSelecionada = null;
        txtTipo.setText("Digite o tipo");
        txtBairro.setText("Bairro do imóvel");
        txtValor.setText("Valor do imóvel (R$)");
        txtDescricao.setText("");
        lblImagem.setIcon(null);
        lblImagem.setText("");
        if (cbListarImobiliarias.getItemCount() > 0) cbListarImobiliarias.setSelectedIndex(0);
    }

    private void cadastrar() {
        String situacao = perguntarSituacao();
        if (situacao == null) return;
        String novaFoto = "";
        try {
            // Validação antes de copiar a foto e gravar no banco.
            ImovelModel imovel = dadosDoFormulario("", situacao);
            // A validação completa é repetida pelo Controller no cadastro.
            if (imagemSelecionada != null) {
                novaFoto = FotoUtils.salvar(imagemSelecionada);
                imovel.setFoto(novaFoto);
            }
            int id = controller.cadastrar(imovel);
            JOptionPane.showMessageDialog(this, "Imóvel cadastrado! ID: " + id);
            limpar();
        } catch (SQLException | IOException | IllegalArgumentException e) {
            FotoUtils.excluir(novaFoto);
            mostrarErro(e);
        }
    }

    private void consultar() {
        try {
            carregarImobiliarias();
            List<ImovelModel> lista = controller.listar();
            Object[][] dados = new Object[lista.size()][7];
            for (int i = 0; i < lista.size(); i++) {
                ImovelModel imovel = lista.get(i);
                String descricao = imovel.getDescricao().replaceAll("\\s+", " ");
                if (descricao.length() > 55) descricao = descricao.substring(0, 55) + "...";
                dados[i] = new Object[]{imovel.getID(), imovel.getTipo(), imovel.getBairro(),
                    String.format(Locale.forLanguageTag("pt-BR"), "%.2f", imovel.getValor()),
                    nomesImobiliarias.getOrDefault(imovel.getIDImobiliaria(), "ID " + imovel.getIDImobiliaria()),
                    imovel.getSituacao(), descricao};
            }
            int id = Catalogo.selecionar(this, "Catálogo de imóveis",
                    new String[]{"ID", "Tipo", "Bairro", "Valor (R$)", "Imobiliária", "Situação", "Descrição"},
                    dados);
            if (id == 0) return;
            ImovelModel imovel = controller.buscarPorId(id);
            if (imovel == null) {
                JOptionPane.showMessageDialog(this, "Imóvel não encontrado.");
                return;
            }
            idSelecionado = imovel.getID();
            fotoAtual = imovel.getFoto();
            situacaoAtual = imovel.getSituacao();
            imagemSelecionada = null;
            txtTipo.setText(imovel.getTipo());
            txtBairro.setText(imovel.getBairro());
            txtValor.setText(String.format(Locale.forLanguageTag("pt-BR"), "%.2f", imovel.getValor()));
            txtDescricao.setText(imovel.getDescricao());
            selecionarImobiliaria(imovel.getIDImobiliaria());
            lblImagem.setIcon(null);
            File foto = FotoUtils.localizar(fotoAtual);
            if (foto != null && foto.isFile()) {
                try { mostrarFoto(foto); }
                catch (IOException e) { lblImagem.setText("Imagem indisponível"); }
            } else if (fotoAtual != null && !fotoAtual.isEmpty()) {
                lblImagem.setText("Imagem indisponível");
            }
        } catch (SQLException e) { mostrarErro(e); }
    }

    private void atualizar() {
        if (idSelecionado == 0) {
            JOptionPane.showMessageDialog(this, "Consulte e selecione um imóvel antes de atualizar.");
            return;
        }
        String situacao = perguntarSituacao();
        if (situacao == null) return;
        String novaFoto = "";
        try {
            ImovelModel imovel = dadosDoFormulario(fotoAtual, situacao);
            if (imagemSelecionada != null) {
                novaFoto = FotoUtils.salvar(imagemSelecionada);
                imovel.setFoto(novaFoto);
            }
            if (!controller.atualizar(imovel)) {
                FotoUtils.excluir(novaFoto);
                JOptionPane.showMessageDialog(this, "Registro não encontrado.");
            } else {
                if (!novaFoto.isEmpty()) FotoUtils.excluir(fotoAtual);
                JOptionPane.showMessageDialog(this, "Imóvel atualizado!");
            }
            limpar();
        } catch (SQLException | IOException | IllegalArgumentException e) {
            FotoUtils.excluir(novaFoto);
            mostrarErro(e);
        }
    }

    private void excluir() {
        if (idSelecionado == 0) {
            JOptionPane.showMessageDialog(this, "Consulte e selecione um imóvel antes de excluir.");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Excluir o imóvel ID " + idSelecionado + "?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            if (controller.excluir(idSelecionado)) {
                FotoUtils.excluir(fotoAtual);
                JOptionPane.showMessageDialog(this, "Imóvel excluído!");
            } else JOptionPane.showMessageDialog(this, "Registro não encontrado.");
            limpar();
        } catch (SQLException e) { mostrarErro(e); }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ImovelView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserirImagem;
    private javax.swing.JButton btnIrParaImoveis;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbListarImobiliarias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
