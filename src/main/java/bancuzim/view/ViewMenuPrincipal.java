package bancuzim.view;


import bancuzim.enums.OpcaoMenu;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.agencia.ViewGerenciarAgencias;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notSair;

public class ViewMenuPrincipal implements CommandLineRunner {

    private Logger log = Logger.getLogger(ViewMenuPrincipal.class);

 /* Deverá possuir todas as views para poder redirecionar a opção escolhida: */

    private ViewGerenciarAgencias viewGerenciarAgencias;
 /* private ViewGerenciarClientes viewGerenciarClientes;
    private ViewGerenciarContas viewGerenciarContas;
    private ViewGerenciarEmprestimos viewGerenciarEmprestimos; */

    @Override
    public void run(String... args) throws Exception {
        /* Instanciar views:
        viewGerenciarClientes = new ViewGerenciarClientes();
        viewGerenciarContas = new ViewGerenciarContas();
        viewGerenciarEmprestimos = new ViewGerenciarEmprestimos(); */
        viewGerenciarAgencias = new ViewGerenciarAgencias();

        manterMenuPrincipal();
    }


    /**
     * * Mantém o menu principal, exibindo e recebendo entradas até que o usuário acione a opção de sair (S).
     */
    public void manterMenuPrincipal() {

        Scanner leitor = new Scanner(System.in);
        OpcaoMenu opcao = CONTINUE;

        while (notSair(opcao)) {
            exibirMenu();
            opcao = Leitura.lerOpcaoMenu("Opção: ", leitor);
            interpretarOpcao(opcao);
        }

    }

    private void exibirMenu() {
        log.warn(Menu.INICIAL);
    }

    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente.
     *
     * @param opcao
     */
    private void interpretarOpcao(OpcaoMenu opcao) {

        switch (opcao) {
            case A: // Gerenciar agências
                viewGerenciarAgencias.run();
                break;

            case B: // Gerenciar clientes
                //  viewGerenciarClientes.run();
                break;

            case C: // Gerenciar contas
                //  viewGerenciarContas.run();
                break;

            case E: // Gerenciar emprestimos
                //  viewGerenciarEmprestimos.run();
                break;

            case S: // SAIR
                log.warn("Tchau!");
                fim();
                break;

            default:
                log.warn("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }

    private void fim() {
        System.exit(0);
    }
}
