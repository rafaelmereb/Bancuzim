package bancuzim.view.agencia;

import bancuzim.enums.OpcaoMenu;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.*;

/**
 * View correspondente à gerência de agências
 */
public class ViewGerenciarAgencias implements CommandLineRunner{

    private Logger log = Logger.getLogger(ViewGerenciarAgencias.class);
    private Scanner entrada;

    @Override
    public void run(String... args){
        /* Instanciar views:
        viewCadastrarAgencia = new ViewCadastrarAgencia();
        viewBuscarAgencia = new ViewBuscarAgencia();
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
        OpcaoMenu opcao = CONTINUE;

        while(!opcao.equals(V)){
            log.warn(Menu.GERENCIAR_AGENCIAS);
            opcao = Leitura.lerOpcaoMenu("Opção: ", entrada);
            interpretarEntrada(opcao);
        }
    }

    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente.
     * @param opcao
     */
    private void interpretarEntrada(OpcaoMenu opcao) {

        switch (opcao){
            case C: // CADASTRAR Agência
                log.warn("\nMenu Cadastrar Agência escolhido!");
            /*  viewCadastrarAgencia.run();*/
                break;

            case B: // BUSCAR por uma agência específica
                log.warn("\nMenu Buscar Agência escolhido!");
            /*  viewCadastrarAgencia.run();*/
                break;

            case A: // ATUALIZAR os dados de uma agência
                log.warn("\nMenu Atualizar Agência escolhido!");
            /*  viewCadastrarAgencia.run();*/
                break;

            case D: // DELETAR uma agência
                log.warn("\nMenu Deletar Agência escolhido!");
            /*  viewCadastrarAgencia.run();*/
                break;

            case L: // LISTAR todas as agências
                log.warn("\nMenu Listar Agências escolhido");
            /*  viewCadastrarAgencia.run();*/
                break;

            case I: // IMPORTAR agências
            /*  viewCadastrarAgencia.run();*/
                log.warn("\nMenu Importar Agência(s) escolhido!");
                break;

            case V: // VOLTAR ao menu principal
                break;

            default:
                log.warn("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }


}
