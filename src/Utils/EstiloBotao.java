package Utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicButtonUI;

public final class EstiloBotao {

    private static final Color FUNDO = Color.decode("#3D3D3D");
    private static final int DURACAO = 200;
    private static final int RAIO = 12;

    public static void aplicar(JButton botao, Color cor) {

        botao.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(botao.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth() - 1,
                        c.getHeight() - 1, RAIO, RAIO);

                g2.setColor(cor);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(0, 0, c.getWidth() - 1,
                        c.getHeight() - 1, RAIO, RAIO);

                g2.dispose();

                super.paint(g, c);
            }
        });

        botao.setOpaque(false);
        botao.setContentAreaFilled(false);
        botao.setBackground(FUNDO);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        final Color[] origem = {FUNDO};
        final Color[] destino = {FUNDO};
        final long[] inicio = {0};

        Timer timer = new Timer(15, e -> {

            double progresso = Math.min(1.0,
                    (System.nanoTime() - inicio[0])
                    / (DURACAO * 1_000_000.0));

            double suavidade = 1 - Math.pow(1 - progresso, 3);

            Color fundo = interpolar(origem[0], destino[0], suavidade);

            botao.setBackground(fundo);
            botao.setForeground(corTexto(fundo));

            botao.repaint();

            if (progresso >= 1.0) {
                ((Timer) e.getSource()).stop();
            }
        });

        botao.addMouseListener(new MouseAdapter() {

            private void animar(Color novaCor) {
                origem[0] = botao.getBackground();
                destino[0] = novaCor;
                inicio[0] = System.nanoTime();
                timer.restart();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                animar(cor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                animar(FUNDO);
            }
        });
    }

    private static Color corTexto(Color fundo) {

        double[] rgb = {
            fundo.getRed() / 255.0,
            fundo.getGreen() / 255.0,
            fundo.getBlue() / 255.0
        };

        for (int i = 0; i < rgb.length; i++) {
            rgb[i] = rgb[i] <= 0.04045
                    ? rgb[i] / 12.92
                    : Math.pow((rgb[i] + 0.055) / 1.055, 2.4);
        }

        double luminancia = 0.2126 * rgb[0]
                + 0.7152 * rgb[1]
                + 0.0722 * rgb[2];

        return luminancia > 0.179 ? Color.BLACK : Color.WHITE;
    }

    private static Color interpolar(Color a, Color b, double t) {

        int r = (int) (a.getRed() + (b.getRed() - a.getRed()) * t);
        int g = (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t);
        int bl = (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t);

        return new Color(r, g, bl);
    }

    private EstiloBotao() {
    }
}
