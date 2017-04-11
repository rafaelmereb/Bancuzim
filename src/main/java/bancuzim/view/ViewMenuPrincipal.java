package bancuzim.view;


import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.*;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.agencia.ViewGerenciarAgencias;
import bancuzim.view.cliente.ViewGerenciarClientes;
import bancuzim.view.conta.ViewGerenciarContas;
import bancuzim.view.emprestimo.ViewGerenciarEmprestimos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notSair;

public class ViewMenuPrincipal {

 /* Deverá possuir todas as views para poder redirecionar a opção escolhida: */

    @Autowired
    private ViewGerenciarAgencias viewGerenciarAgencias;

    @Autowired
    private ViewGerenciarClientes viewGerenciarClientes;

    @Autowired
    private ViewGerenciarContas viewGerenciarContas;

    @Autowired
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
    private void manterMenuPrincipal(){
        OpcaoMenu opcao = CONTINUE;

        while (notSair(opcao)) {
            exibirMenu();
            opcao = Leitura.lerOpcaoMenu();
            interpretarOpcao(opcao);
        }

    }

    private void exibirMenu() {
        System.out.println(Menu.INICIAL);
    }

    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente.
     *
     * @param opcao opção escolhida pelo usuário
     */
    private void interpretarOpcao(OpcaoMenu opcao) {

        switch (opcao) {
            case A: // Gerenciar agências
                viewGerenciarAgencias.load();
                break;

            case B: // Gerenciar clientes
                //  viewGerenciarClientes.load();
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

    private void fim() {
        System.exit(0);
    }
}
