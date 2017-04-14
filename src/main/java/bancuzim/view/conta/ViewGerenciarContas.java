package bancuzim.view.conta;

import bancuzim.entity.Conta;
import bancuzim.enums.OpcaoMenu;
import bancuzim.service.ContaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notVoltar;

public class ViewGerenciarContas extends ViewMenuPrincipal{
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
     * Colhe dados do cliente a ser cadastrado
     *
     * @return cliente cujos dados foram colhidos
     */
    public Conta colherDadosDeCliente() {
        Conta conta = new Conta();
        //TODO: Progredir gerencia de clientes
        /*
        conta.set(Leitura.lerCampoStringObrigatorio("Nome do Cliente da Conta: "));
        conta.setCpfCnpj(Leitura.lerCPFouCNPJvalido());
        conta.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço do Cliente: "));
        conta.setData_de_nascimento(Leitura.lerCampoDateObrigatorio("Data de nascimento do Cliente: "));
        conta.setSexo(Leitura.lerSexoObrigatorio());

        */

        return conta;
    }
}
