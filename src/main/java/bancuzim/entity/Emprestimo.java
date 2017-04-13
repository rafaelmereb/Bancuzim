package bancuzim.entity;

import bancuzim.enums.TipoEmprestimo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidade Emprestimo
 */
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome_cliente;
    private String cpf_cnpj;
    private TipoEmprestimo tipo_emprestimo;
    private Double valor;

    public Emprestimo(){
        super();
    }

    public Emprestimo(String nome_cliente, String cpf_cnpj, TipoEmprestimo tipo_emprestimo, double valor) {
        super();
        this.nome_cliente = nome_cliente;
        this.cpf_cnpj = cpf_cnpj;
        this.tipo_emprestimo = tipo_emprestimo;
        this.valor = valor;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public TipoEmprestimo getTipo_emprestimo() {
        return tipo_emprestimo;
    }

    public void setTipo_emprestimo(TipoEmprestimo tipo_emprestimo) {
        this.tipo_emprestimo = tipo_emprestimo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
