package bancuzim.model;

/**
 * Created by RAFAEL-OOBJ on 27/03/2017.
 */
public class Agencia {
    private String nome;
    private String codigo;
    private String endereco;
    private String gerente;

    public Agencia(){
        super();
    }

    public Agencia(String nome, String codigo, String endereco, String gerente) {
        super();
        this.nome = nome;
        this.codigo = codigo;
        this.endereco = endereco;
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
}
