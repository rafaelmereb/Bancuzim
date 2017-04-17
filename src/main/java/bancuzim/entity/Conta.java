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

    private String numero;
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
            conta = "Conta {" +
                    " Id = " + id +
                    ", Número da Conta = '" + numero + "'" +
                    ", Nome da Agência: " + agencia.getNome() +
                    ", Código da Agência = " + agencia.getCodigo() +
                    ", Cliente Responsável= " + cliente.getNome() +
                    ", Tipo da Conta = " + tipo_conta.name() +
                    ", Plano = " + plano.name() +
                    ", Saldo = " + saldo +
                    ", Limite = " + limite +
                    '}';
        } else {
            conta = "Conta { " +
                    " Id = " + id +
                    ", Número da Conta = '" + numero + "'" +
                    ", Nome da Agência: " + agencia.getNome() +
                    ", Código da agência = " + agencia.getCodigo() +
                    ", Cliente Responsável= " + cliente.getNome() +
                    ", Tipo da Conta = " + tipo_conta.name() +
                    ", Saldo = " + saldo +
                    ", Limite = " + limite +
                    '}';
        }
        return conta;
    }
}
