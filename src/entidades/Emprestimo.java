package entidades;

import enums.Tipo_Emprestimo;

/**
 * Created by RAFAEL-OOBJ on 27/03/2017.
 */
public class Emprestimo {

    private String nome_cliente;
    private String cpf_cnpj;
    private Tipo_Emprestimo tipo_emprestimo;
    private double valor;

    public Emprestimo(){
        super();
    }

    public Emprestimo(String nome_cliente, String cpf_cnpj, Tipo_Emprestimo tipo_emprestimo, double valor) {
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

    public Tipo_Emprestimo getTipo_emprestimo() {
        return tipo_emprestimo;
    }

    public void setTipo_emprestimo(Tipo_Emprestimo tipo_emprestimo) {
        this.tipo_emprestimo = tipo_emprestimo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
