package bancuzim.entity;

import bancuzim.enums.TipoEmprestimo;

import javax.persistence.*;

@Entity
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Cliente cliente;

//    private String nome_cliente;
//    private String cpfCnpj;
    private TipoEmprestimo tipo_emprestimo;
    private Double valor;

    public Emprestimo(){
        super();
    }

    public Emprestimo(TipoEmprestimo tipo_emprestimo, double valor) {
        super();
        this.tipo_emprestimo = tipo_emprestimo;
        this.valor = valor;
    }


    public Emprestimo(Cliente cliente, TipoEmprestimo tipo_emprestimo, double valor) {
        super();
        this.cliente = cliente;
        this.tipo_emprestimo = tipo_emprestimo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEmprestimo getTipo_emprestimo() {
        return tipo_emprestimo;
    }

    public void setTipo_emprestimo(TipoEmprestimo tipo_emprestimo) {
        this.tipo_emprestimo = tipo_emprestimo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Empréstimo { " +
                "Id = " + id +
                ", CPF/CNPJ do Cliente Responsável = " + cliente.getCpfCnpj() +
                ", Tipo do Empréstimo = " + tipo_emprestimo +
                ", Valor do Bem = " + valor +
                " }";
    }
}
