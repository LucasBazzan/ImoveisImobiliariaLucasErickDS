package Model;
import lombok.Data;

@Data
public class ImovelModel {
    private int ID;
    private String Descricao;
    private int IDImobiliaria;
    private String Tipo;
    private float Valor;
    private String Bairro;
    private String Foto;
    private String Situacao;
}
