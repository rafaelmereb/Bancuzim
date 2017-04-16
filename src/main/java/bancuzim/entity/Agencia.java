package bancuzim.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Conta> contas;

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

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Agência {" +
                " Id = " + id +
                ", Código = " + codigo +
                ", Nome = '" + nome + '\'' +
                ", Endereço = '" + endereco + '\'' +
                ", Gerente = '" + gerente + '\'' +
              //  ", Contas = " + contas +
                '}';
    }
}
