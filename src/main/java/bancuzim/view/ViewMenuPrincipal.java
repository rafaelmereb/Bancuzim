package bancuzim.view;

import bancuzim.enums.OpcaoMenu;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.agencia.ViewGerenciarAgencias;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.*;

public class ViewMenuPrincipal implements CommandLineRunner{

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
    public void manterMenuPrincipal(){

        try (Scanner scanner = new Scanner(System.in)) {

            OpcaoMenu opcao = CONTINUE;

            while(!opcao.equals(S)){

                log.warn(Menu.INICIAL);
                opcao = Leitura.lerOpcaoMenu("Opção: ", scanner);
                interpretarOpcao(opcao);
            }
        }
    }

    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente.
     * @param opcao
     */
    private void interpretarOpcao(OpcaoMenu opcao){


        switch (opcao){  //OBS: Usar ExecutorService + Future para aguardar a execução dos submenus
            case A: // Gerenciar agências
                log.warn("\nMenu Gerenciar agências escolhido!");
                viewGerenciarAgencias.run();
                break;

            case B: // Gerenciar clientes
                log.warn("\nMenu Gerenciar clientes escolhido!");
            //  viewGerenciarClientes.run();
                break;

            case C: // Gerenciar contas
                log.warn("\nMenu Gerenciar contas escolhido!");
            //  viewGerenciarContas.run();
                break;

            case E: // Gerenciar emprestimos
                log.warn("\nMenu Gerenciar empréstimos escolhido!");
            //  viewGerenciarEmprestimos.run();
                break;

            case S: // SAIR
                log.warn("Tchau!");
                break;

            default:
                log.warn("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }

}
