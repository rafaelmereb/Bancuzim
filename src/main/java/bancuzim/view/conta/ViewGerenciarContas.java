package bancuzim.view.conta;

import bancuzim.entity.Agencia;
import bancuzim.entity.Cliente;
import bancuzim.entity.Conta;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.service.ContaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static bancuzim.enums.Entidade.CONTA;
import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notVoltar;
import static bancuzim.enums.TipoConta.CORRENTE;
import static bancuzim.util.Leitura.lerCampoStringObrigatorio;
import static bancuzim.util.Leitura.lerTipoConta;

public class ViewGerenciarContas extends ViewMenuPrincipal {

    @Autowired
    @Qualifier("contaService")
    public ContaService contaService;
    @Autowired
    @Qualifier("viewCadastrarConta")
    public ViewCadastrarConta viewCadastrarConta;
    @Autowired
    @Qualifier("viewImportarContas")
    private ViewImportarContas viewImportarContas;
    @Autowired
    @Qualifier("viewListarContas")
    private ViewListarContas viewListarContas;
    @Autowired
    @Qualifier("viewDeletarConta")
    private ViewDeletarConta viewDeletarConta;
    @Autowired
    @Qualifier("viewAtualizarConta")
    private ViewAtualizarConta viewAtualizarConta;
    @Autowired
    @Qualifier("viewBuscarConta")
    private ViewBuscarConta viewBuscarConta;

    /**
     * "Carrega" a View responsável por Gerenciar operações referentes a Contas
     */
    public void load() {
        manterViewGerenciasContas();
    }

    /**
     * Mantém a View responsável por Gerenciar operações referentes a Contas
     */
    private void manterViewGerenciasContas() {
        OpcaoMenu opcao = CONTINUE;

        while (notVoltar(opcao)) {
            exibirMenu(Menu.GERENCIAR_CONTAS);
            opcao = Leitura.lerOpcaoMenu();
            interpretarEntrada(opcao, viewCadastrarConta, viewBuscarConta, viewAtualizarConta, viewDeletarConta, viewListarContas, viewImportarContas);
        }
    }

    /**
     * Colhe dados da conta a ser cadastrada
     *
     * @return conta cujos dados foram colhidos
     */
    public Conta colherDadosDeConta() throws FalhaCadastroException {
        Conta conta = new Conta();


        conta.setNumero(colherNumeroDaConta());

        try{
            conta.setAgencia(colherAgencia());
            conta.setCliente(colherCliente());
        } catch (FalhaBuscaException falha) {
            throw new FalhaCadastroException(CONTA, falha.getDescricaoFalha());
        }

        conta.setTipo_conta(lerTipoConta());

        if (conta.getTipo_conta().equals(CORRENTE)) {
            //Caso seja uma conta corrente, ela tem um plano:
            conta.setPlano(Leitura.lerPlano());
        }

        conta.setSaldo(Leitura.lerCampoDoubleObrigatorio("Saldo da conta: "));
        conta.setLimite(Leitura.lerCampoDoubleObrigatorio("Limite da conta: "));

        return conta;
    }

    /**
     * Colhe o número da Conta a ser adotado pela mesma
     *
     * @return número da conta escolhido
     */
    public String colherNumeroDaConta() {
        return lerCampoStringObrigatorio("Número da conta:");
    }

    /**
     * Colhe Agência relacionada à Conta
     *
     * @return Agência  relacionada à conta
     * @throws FalhaBuscaException caso a agência não seja encontrada
     */
    public Agencia colherAgencia() throws FalhaBuscaException {
        System.out.println("##### Agência da Conta #####");
        return viewGerenciarAgencias.buscarAgencia();
    }

    /**
     * Colhe cliente relacionado à Conta
     *
     * @return Cliente relacionado à conta
     * @throws FalhaBuscaException caso o cliente não seja encontrado
     */
    private Cliente colherCliente() throws FalhaBuscaException {
        System.out.println("##### Cliente da Conta #####");
        return viewGerenciarClientes.escolherClienteDesejado(viewGerenciarClientes.buscarClientes());
    }

    /**
     * Exibe uma conta no console
     *
     * @param conta a ser exibida
     */
    public void exibirConta(Conta conta) {
        if (conta != null) {
            System.out.println(conta.toString());
        }
    }

    /**
     * Confere a responsabilidade de buscar uma conta à service correspondente, a partir dos dados da conta (número e agência)
     *
     * @return
     * @throws FalhaBuscaException
     */
    public Conta buscarConta() throws FalhaBuscaException {
        return contaService.buscarConta(colherNumeroDaConta(), colherAgencia());
    }

}
