package bancuzim.entity;

import bancuzim.enums.TipoConta;

import javax.persistence.*;


/**
 * Entidade Conta.
 */
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Agencia agencia;
    @ManyToOne
    private Cliente cliente;

    private String nome_agencia;
    private Integer codigo_agencia;
    private Integer numero;
    private String nome_cliente;
    private String codigo_cliente;
    private TipoConta tipo_conta;
    private Double saldo;
    private Double limite;

    public Conta() {
        super();
    }

    public Conta(String nome_agencia, Integer codigo_agencia, Integer numero, String nome_cliente, String codigo_cliente, TipoConta tipo_conta, Double saldo, Double limite) {
        this.nome_agencia = nome_agencia;
        this.codigo_agencia = codigo_agencia;
        this.numero = numero;
        this.nome_cliente = nome_cliente;
        this.codigo_cliente = codigo_cliente;
        this.tipo_conta = tipo_conta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(Agencia agencia, Cliente cliente, Integer numero, TipoConta tipo_conta, Double saldo, Double limite) {
        this.agencia = agencia;
        this.cliente = cliente;
        this.numero = numero;
        this.tipo_conta = tipo_conta;
        this.saldo = saldo;
        this.limite = limite;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNome_agencia() {
        return nome_agencia;
    }

    public void setNome_agencia(String nome_agencia) {
        this.nome_agencia = nome_agencia;
    }

    public Integer getCodigo_agencia() {
        return codigo_agencia;
    }

    public void setCodigo_agencia(Integer codigo_agencia) {
        this.codigo_agencia = codigo_agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public TipoConta getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(TipoConta tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
