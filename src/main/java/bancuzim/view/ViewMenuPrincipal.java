package bancuzim.view;


import bancuzim.enums.OpcaoMenu;
import bancuzim.interfaces.*;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.agencia.ViewGerenciarAgencias;
import bancuzim.view.cliente.ViewGerenciarClientes;
import bancuzim.view.conta.ViewGerenciarContas;
import bancuzim.view.emprestimo.ViewGerenciarEmprestimos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

import static bancuzim.enums.OpcaoMenu.*;

public class ViewMenuPrincipal implements ViewInterface {

 /* Deverá possuir todas as views para poder redirecionar a opção escolhida: */

    @Autowired @Qualifier("viewGerenciarAgencias")
    private ViewGerenciarAgencias viewGerenciarAgencias;

    @Autowired @Qualifier("viewGerenciarClientes")
    private ViewGerenciarClientes viewGerenciarClientes;

    @Autowired @Qualifier("viewGerenciarContas")
    private ViewGerenciarContas viewGerenciarContas;

    @Autowired @Qualifier("viewGerenciarEmprestimos")
    private ViewGerenciarEmprestimos viewGerenciarEmprestimos;

    /**
     * "Carrega" a view responsável pelo Menu Principal
     */
    public void load() {
        manterMenuPrincipal();
    }

    /**
     * * Mantém o menu principal, exibindo e recebendo entradas até que o usuário acione a opção de sair (S).
     */
    private void manterMenuPrincipal() {
        OpcaoMenu opcao = CONTINUE;

        while (notSair(opcao)) {
            exibirMenu(Menu.INICIAL);
            opcao = Leitura.lerOpcaoMenu();
            interpretarOpcaoDoMenuPrincipal(opcao);
        }

    }


    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view de gerência correspondente.
     *
     * @param opcao opção escolhida pelo usuário
     */
    private void interpretarOpcaoDoMenuPrincipal(OpcaoMenu opcao) {

        switch (opcao) {
            case A: // Gerenciar agências
                viewGerenciarAgencias.load();
                break;

            case B: // Gerenciar clientes
                viewGerenciarClientes.load();
                break;

            case C: // Gerenciar contas
                //  viewGerenciarContas.load();
                break;

            case E: // Gerenciar emprestimos
                //  viewGerenciarEmprestimos.load();
                break;

            case S: // SAIR
                System.out.println("Tchau!");
                fim();
                break;

            default:
                System.out.println("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }

    /**
     * Exibe o menu indicado
     *
     * @param menu indicado
     */
    public void exibirMenu(String menu) {
        System.out.println(menu);
    }


    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente.
     *
     * @param opcao escolhida pelo usuário
     * @param viewCadastrar (implementação da interface para a entidade correspondente)
     * @param viewBuscar (implementação da interface para a entidade correspondente)
     * @param viewAtualizar (implementação da interface para a entidade correspondente)
     * @param viewDeletar (implementação da interface para a entidade correspondente)
     * @param viewListarTodos (implementação da interface para a entidade correspondente)
     * @param viewImportar (implementação da interface para a entidade correspondente)
     */
     public void interpretarEntrada(OpcaoMenu opcao, ViewCadastrarInterface viewCadastrar,
                                    ViewBuscarInterface viewBuscar, ViewAtualizarInterface viewAtualizar,
                                    ViewDeletarInterface viewDeletar, ViewListarTodosInterface viewListarTodos,
                                    ViewImportarInterface viewImportar) {

        switch (opcao) {
            case C: // CADASTRAR
                viewCadastrar.load();
                break;

            case B: // BUSCAR
                viewBuscar.load();
                break;

            case A: // ATUALIZAR
                viewAtualizar.load();
                break;

            case D: // DELETAR
                viewDeletar.load();
                break;

            case L: // LISTAR
                viewListarTodos.load();
                break;

            case I: // IMPORTAR
                viewImportar.load();
                break;

            case V: // VOLTAR
                break;

            default:
                System.out.println("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }

    /**
     * Colhe a referência que será utilizada na busca de uma entidade qualquer, entre duas opcoes
     *
     * @return referência que será utilizada na busca da entidade
     */
    public OpcaoMenu colherReferenciaParaBusca(String opcaoA, String opcaoB) {
        OpcaoMenu opcao = CONTINUE;
        ArrayList<OpcaoMenu> opcoesDisponiveis = new ArrayList<>();
        opcoesDisponiveis.add(A);
        opcoesDisponiveis.add(B);

        while (!opcoesDisponiveis.contains(opcao)) {
            System.out.println("Escolha a referência a ser utilizada no processo:\nA - " + opcaoA + "\nB - " + opcaoB);
            opcao = Leitura.lerOpcaoMenu();
            switch (opcao) {
                case A:
                case B:
                    return opcao;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        return opcao;
    }
    private void fim() {
        System.exit(0);
    }
}
