package bancuzim.entity;

import bancuzim.enums.Sexo;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
/**
 * Entidade Cliente. TODO: VERIFICAR DEMAIS PARÂMETROS E RELACIONAMENTOS. A CLASSE AINDA NÃO FOI FINALIZADA
 */
public class Cliente {

    @Id @GeneratedValue
    private Integer id;
    private String cpf_cnpj;
    private String nome;
    private String endereco;
    private String data_de_nascimento;
    private Sexo sexo;

    public Cliente(){
        super();
    }

    public Cliente(String nome, String cpf_cnpj, String endereco, String data_de_nascimento, Sexo sexo) {
        super();
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.data_de_nascimento = data_de_nascimento;
        this.sexo = sexo;
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

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
