package bancuzim.view.emprestimo;

import bancuzim.entity.Cliente;
import bancuzim.entity.Emprestimo;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.service.EmprestimoService;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import bancuzim.view.cliente.ViewGerenciarClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static bancuzim.enums.Entidade.EMPRESTIMO;
import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notVoltar;
import static bancuzim.util.Leitura.*;

public class ViewGerenciarEmprestimos extends ViewMenuPrincipal {

    @Autowired
    @Qualifier("emprestimoService")
    EmprestimoService emprestimoService;
    @Autowired
    @Qualifier("viewGerenciarClientes")
    ViewGerenciarClientes viewGerenciarClientes;
    @Autowired
    @Qualifier("viewCadastrarEmprestimo")
    ViewCadastrarEmprestimo viewCadastrarEmprestimo;
    @Autowired
    @Qualifier("viewImportarEmprestimos")
    ViewImportarEmprestimos viewImportarEmprestimos;
    @Autowired
    @Qualifier("viewListarEmprestimos")
    ViewListarEmprestimos viewListarEmprestimos;
    @Autowired
    @Qualifier("viewDeletarEmprestimo")
    ViewDeletarEmprestimo viewDeletarEmprestimo;
    @Autowired
    @Qualifier("viewAtualizarEmprestimo")
    ViewAtualizarEmprestimo viewAtualizarEmprestimo;
    @Autowired
    @Qualifier("viewBuscarEmprestimo")
    ViewBuscarEmprestimo viewBuscarEmprestimo;

    /**
     * "Carrega" a View responsável por Gerenciar operações referentes a Empréstimos
     */
    public void load() {
        manterViewGerenciarClientes();
    }

    /**
     * Mantém a View responsável por Gerenciar operações referentes a Empréstimos
     */
    private void manterViewGerenciarClientes() {
        OpcaoMenu opcao = CONTINUE;

        while (notVoltar(opcao)) {
            exibirMenu(Menu.GERENCIAR_EMPRESTIMOS);
            opcao = lerOpcaoMenu();
            interpretarEntrada(opcao, viewCadastrarEmprestimo, viewBuscarEmprestimo, viewAtualizarEmprestimo, viewDeletarEmprestimo, viewListarEmprestimos, viewImportarEmprestimos);
        }
    }

    /**
     * Colhe dados do empréstimo a ser cadastrado
     *
     * @return empréstimo cujos dados foram colhidos
     * @throws FalhaBuscaException caso o cliente informado não seja encontrado
     */
    public Emprestimo colherDadosDeEmprestimo() throws FalhaBuscaException {
        Emprestimo emprestimo = new Emprestimo();

        try {
            emprestimo.setCliente(colherCliente());
        } catch (FalhaBuscaException falha) {
            throw new FalhaBuscaException(EMPRESTIMO, falha.getDescricaoFalha());
        }

        emprestimo.setTipo_emprestimo(lerTipoEmprestimo());
        emprestimo.setValor(lerCampoDoubleObrigatorio("Valor do bem: "));

        return emprestimo;
    }

    /**
     * Colhe cliente relacionado ao empréstimo
     *
     * @return Cliente relacionado ao empréstimo
     * @throws FalhaBuscaException caso o cliente não seja encontrado
     */
    private Cliente colherCliente() throws FalhaBuscaException {
        System.out.println("##### Cliente que possui o empréstimo #####");
        return viewGerenciarClientes.escolherClienteDesejado(viewGerenciarClientes.buscarClientes());
    }

    /**
     * Exibe um empréstimo no console
     *
     * @param emprestimo a ser exibido
     */
    public void exibirEmprestimo(Emprestimo emprestimo) {
        if (emprestimo != null) {
            System.out.println(emprestimo.toString());
        }
    }


    public Emprestimo buscarEmprestimo() throws FalhaBuscaException {
        try {
            return emprestimoService.buscarEmprestimo(viewGerenciarClientes.escolherClienteDesejado(viewGerenciarClientes.buscarClientes()).getCpfCnpj());
        } catch (FalhaBuscaException e) {
            throw new FalhaBuscaException(EMPRESTIMO, e.getDescricaoFalha());
        }
    }
}
