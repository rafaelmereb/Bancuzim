package bancuzim.view.cliente;

import bancuzim.enums.OpcaoMenu;
import bancuzim.service.ClienteService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notVoltar;

public class ViewGerenciarClientes extends ViewMenuPrincipal{

    @Autowired @Qualifier("viewCadastrarCliente")
    private ViewCadastrarCliente viewCadastrarCliente;
    @Autowired @Qualifier("viewImportarClientes")
    private ViewImportarClientes viewImportarClientes;
    @Autowired @Qualifier("viewListarClientes")
    private ViewListarClientes viewListarClientes;
    @Autowired @Qualifier("viewDeletarCliente")
    private ViewDeletarCliente viewDeletarCliente;
    @Autowired @Qualifier("viewAtualizarCliente")
    private ViewAtualizarCliente viewAtualizarCliente;
    @Autowired @Qualifier("viewBuscarCliente")
    private ViewBuscarCliente viewBuscarCliente;
    @Autowired @Qualifier("clienteService")
    public ClienteService clienteService;

    /**
     * "Carrega" a View responsável por Gerenciar operações referentes a Clientes
     */
    public void load() {
        manterViewGerenciarClientes();
    }

    /**
     * Mantém a View responsável por Gerenciar operações referentes a Clientes
     */
    private void manterViewGerenciarClientes() {
        OpcaoMenu opcao = CONTINUE;

        while (notVoltar(opcao)) {
            exibirMenu(Menu.GERENCIAR_CLIENTES);
            opcao = Leitura.lerOpcaoMenu();
            interpretarEntrada(opcao, viewCadastrarCliente, viewBuscarCliente, viewAtualizarCliente, viewDeletarCliente, viewListarClientes,viewImportarClientes);
        }
    }
}
