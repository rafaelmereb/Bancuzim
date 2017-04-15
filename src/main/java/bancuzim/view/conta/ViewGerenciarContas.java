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
    public Conta colherDadosDeConta() {
        Conta conta = new Conta();

        String nome_codigo_agencia = Leitura.lerCampoStringObrigatorio("Nome/Codigo da agência vinculada à conta: ");

        try {
            conta.setCodigo_agencia(Integer.parseInt(nome_codigo_agencia));
            //Caso não seja possível converter a entrada do usuário, possivelmente a mesma corresponde ao nome de uma agência:
        } catch (NumberFormatException e) {
            conta.setNome_agencia(nome_codigo_agencia);
        }

        conta.setNumero(Leitura.lerCampoStringObrigatorio("Número da conta:"));
        String nome_codigo_cliente = Leitura.lerCampoStringObrigatorio("Nome/Código do cliente vinculado à conta:");

        try {
            conta.setCodigo_cliente(Integer.parseInt(nome_codigo_agencia));
            //Caso não seja possível converter a entrada do usuário, possivelmente a mesma corresponde ao nome de um cliente:
        } catch (NumberFormatException e) {
            conta.setNome_cliente(nome_codigo_cliente);
        }

        conta.setTipo_conta(Leitura.lerTipoConta());
        
        return conta;
    }
}
