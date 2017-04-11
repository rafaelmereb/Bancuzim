package bancuzim.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer codigo;
    private String nome;
    private String endereco;
    private String gerente;

    public Agencia() {
        super();
    }

    public Agencia(Integer codigo, String nome, String endereco, String gerente) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.gerente = gerente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Agencia: {" +
                "codigo: " + codigo +
                ", nome: '" + nome + '\'' +
                ", endereco: '" + endereco + '\'' +
                ", gerente: '" + gerente + '\'' +
                '}';
    }


}
