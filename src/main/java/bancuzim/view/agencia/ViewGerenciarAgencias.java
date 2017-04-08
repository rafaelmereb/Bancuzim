package bancuzim.view.agencia;


import bancuzim.enums.OpcaoMenu;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PostConstruct;
import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notVoltar;

/**
 * View correspondente à gerência de agências
 */
public class ViewGerenciarAgencias implements CommandLineRunner{

    private Logger log = Logger.getLogger(ViewGerenciarAgencias.class);

    ViewCadastrarAgencia viewCadastrarAgencia;

    @Override
    @PostConstruct
    public void run(String... args){

        viewCadastrarAgencia = new ViewCadastrarAgencia();
     /* viewBuscarAgencia = new ViewBuscarAgencia();
        viewAtualizarAgencia = new ViewAtualizarAgencia();
        viewDeletarAgencia = new ViewDeletarAgencia();
        viewListarAgencias = new ViewListarAgencias();
        viewImportarAgencias = new ViewImportarAgencias();
        */

        manterMenuGerenciarAgencias();
    }

    /**
     * Mantém o menu de gerência de agências enquanto a opção não for V (Voltar)
     */
    public void manterMenuGerenciarAgencias() {
        Scanner leitor = new Scanner(System.in);
        OpcaoMenu opcao = CONTINUE;

        while(notVoltar(opcao)){
            exibirMenu();
            opcao = Leitura.lerOpcaoMenu("Opção: ", leitor);
            interpretarEntrada(opcao);
        }
    }

    private void exibirMenu() {
        log.warn(Menu.GERENCIAR_AGENCIAS);
    }


    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente
     *
     * @param opcao escolhida pelo usuário
     */
    private void interpretarEntrada(OpcaoMenu opcao) {

        switch (opcao) {
            case C: // CADASTRAR Agência
                viewCadastrarAgencia.run();
                break;

            case B: // BUSCAR por uma agência específica

            /*  viewCadastrarAgencia.run();*/
                break;

            case A: // ATUALIZAR os dados de uma agência
            /*  viewCadastrarAgencia.run();*/
                break;

            case D: // DELETAR uma agência
            /*  viewCadastrarAgencia.run();*/
                break;

            case L: // LISTAR todas as agências
            /*  viewCadastrarAgencia.run();*/
                break;

            case I: // IMPORTAR agências
            /*  viewCadastrarAgencia.run();*/
                break;

            case V: // VOLTAR ao menu principal
                break;

            default:
                log.warn("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }

}
