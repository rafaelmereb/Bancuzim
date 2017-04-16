package bancuzim.entity;

import bancuzim.enums.Plano;
import bancuzim.enums.TipoConta;

import javax.persistence.*;


@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Agencia agencia;
    @ManyToOne
    private Cliente cliente;

//    private String nome_agencia;
//    private Integer codigo_agencia;
    private String numero;
//    private String nome_cliente;
//    private Integer codigo_cliente;
    private TipoConta tipo_conta;
    private Plano plano;
    private Double saldo;
    private Double limite;

    public Conta() {
        super();
    }

    public Conta(String numero, TipoConta tipo_conta, Double saldo, Double limite) {
        this.numero = numero;
        this.tipo_conta = tipo_conta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(String numero, TipoConta tipo_conta, Plano plano, Double saldo, Double limite) {
        this.numero = numero;
        this.tipo_conta = tipo_conta;
        this.plano = plano;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(Agencia agencia, Cliente cliente, String numero, TipoConta tipo_conta, Double saldo, Double limite) {
        this.agencia = agencia;
        this.cliente = cliente;
        this.numero = numero;
        this.tipo_conta = tipo_conta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(Agencia agencia, Cliente cliente, String numero, TipoConta tipo_conta, Plano plano, Double saldo, Double limite) {
        this.agencia = agencia;
        this.cliente = cliente;
        this.numero = numero;
        this.tipo_conta = tipo_conta;
        this.plano = plano;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /*

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


    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public Integer getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Integer codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    */

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

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        String conta;

        if (getTipo_conta().equals(TipoConta.CORRENTE)) {
            conta = "Conta{" +
                    "id = " + id +
                    ", número da conta = '" + numero + "'" +
                    ", código da agência = " + agencia.getCodigo() +
                    ", cliente = " + cliente.getNome() +
                    ", tipo da conta = " + tipo_conta.name() +
                    ", plano = " + plano.name() +
                    ", saldo = " + saldo +
                    ", limite = " + limite +
                    '}';
        } else {
            conta = "Conta{" +
                    "id = " + id +
                    ", número da conta = '" + numero + "'" +
                    ", código da agência = " + agencia.getCodigo() +
                    ", cliente = " + cliente.getNome() +
                    ", tipo da conta = " + tipo_conta.name() +
                    ", saldo = " + saldo +
                    ", limite = " + limite +
                    '}';
        }
        return conta;
    }
}
