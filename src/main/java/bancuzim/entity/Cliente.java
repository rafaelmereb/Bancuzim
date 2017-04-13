package bancuzim.entity;

import bancuzim.enums.Sexo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cpf_cnpj;
    private String endereco;
    private Date data_de_nascimento;
    private Sexo sexo;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Conta> contas;

    public Cliente(){
        super();
    }

    public Cliente(String nome, String cpf_cnpj, String endereco, Date data_de_nascimento, Sexo sexo) {
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.data_de_nascimento = data_de_nascimento;
        this.sexo = sexo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }


    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }
}
