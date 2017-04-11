package bancuzim.entity;

import bancuzim.enums.Tipo_Conta;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;


/**
 * Entidade Conta. TODO: VERIFICAR DEMAIS PARÂMETROS E RELACIONAMENTOS. A CLASSE AINDA NÃO FOI FINALIZADA
 */
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome_agencia;
    private String codigo_agencia;
    private String numero_conta;
    private String nome_cliente;
    private String codigo_cliente;
    private Tipo_Conta tipo_conta;
    private double saldo;
    private double limite;

    public Conta() {
        super();
    }

    public Conta(String nome_agencia, String codigo_agencia, String numero_conta,
                 String nome_cliente, String codigo_cliente, Tipo_Conta tipo_conta, double saldo,
                 double limite) {
        super();
        this.nome_agencia = nome_agencia;
        this.codigo_agencia = codigo_agencia;
        this.numero_conta = numero_conta;
        this.nome_cliente = nome_cliente;
        this.codigo_cliente = codigo_cliente;
        this.tipo_conta = tipo_conta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public String getNome_agencia() {
        return nome_agencia;
    }

    public void setNome_agencia(String nome_agencia) {
        this.nome_agencia = nome_agencia;
    }

    public String getCodigo_agencia() {
        return codigo_agencia;
    }

    public void setCodigo_agencia(String codigo_agencia) {
        this.codigo_agencia = codigo_agencia;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Tipo_Conta getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(Tipo_Conta tipo_conta) {
        this.tipo_conta = tipo_conta;
    }
}
