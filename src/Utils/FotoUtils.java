package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.UUID;
import javax.imageio.ImageIO;

public final class FotoUtils {
    private static final Path PASTA = Path.of(
        System.getProperty("user.home"), "ImoveisImobiliariaLucasErickDS", "fotos");

    private FotoUtils() { }

    public static String salvar(File arquivo) throws IOException {
        if (arquivo == null || !arquivo.isFile() || ImageIO.read(arquivo) == null)
            throw new IOException("Selecione uma imagem válida.");
        String nome = arquivo.getName().toLowerCase(Locale.ROOT);
        String extensao = nome.endsWith(".png") ? ".png" :
                          nome.endsWith(".jpg") || nome.endsWith(".jpeg") ? ".jpg" : "";
        if (extensao.isEmpty()) throw new IOException("A foto deve ser PNG, JPG ou JPEG.");
        Files.createDirectories(PASTA);
        String novoNome = UUID.randomUUID().toString().replace("-", "") + extensao;
        Files.copy(arquivo.toPath(), PASTA.resolve(novoNome));
        return novoNome;
    }

    public static File localizar(String nome) {
        if (nome == null || !nome.matches("[a-f0-9]{32}\\.(png|jpg)")) return null;
        return PASTA.resolve(nome).toFile();
    }

    public static void excluir(String nome) {
        File arquivo = localizar(nome);
        if (arquivo != null) {
            try { Files.deleteIfExists(arquivo.toPath()); }
            catch (IOException e) { System.err.println("Falha ao excluir foto: " + e.getMessage()); }
        }
    }
}
