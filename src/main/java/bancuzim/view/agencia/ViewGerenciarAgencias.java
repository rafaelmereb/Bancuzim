package bancuzim.view.agencia;


import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.FalhaAtualizacaoException;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.exception.FalhaDelecaoException;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.CONTINUE;
import static bancuzim.enums.OpcaoMenu.notVoltar;

/**
 * View correspondente à gerência de agências
 */
public class ViewGerenciarAgencias{

    @Autowired
    private ViewCadastrarAgencia viewCadastrarAgencia;

    @Autowired
    private ViewBuscarAgencia viewBuscarAgencia;

    @Autowired
    private ViewAtualizarAgencia viewAtualizarAgencia;

    @Autowired
    private ViewDeletarAgencia viewDeletarAgencia;

    public void load() throws FalhaCadastroException, FalhaBuscaException, FalhaDelecaoException, FalhaAtualizacaoException {
        manterMenuGerenciarAgencias();
    }

    /**
     * Mantém o menu de gerência de agências enquanto a opção não for V (Voltar)
     */
    private void manterMenuGerenciarAgencias() throws FalhaCadastroException, FalhaBuscaException, FalhaDelecaoException, FalhaAtualizacaoException {
        Scanner leitor = new Scanner(System.in);
        OpcaoMenu opcao = CONTINUE;

        while(notVoltar(opcao)){
            exibirMenu();
            opcao = Leitura.lerOpcaoMenu(leitor);
            interpretarEntrada(opcao);
        }
    }

    private void exibirMenu() {
        System.out.println(Menu.GERENCIAR_AGENCIAS);
    }


    /**
     * Interpreta a opção escolhida pelo usuário, mapeando-a para a view correspondente
     *
     * @param opcao escolhida pelo usuário
     */
    private void interpretarEntrada(OpcaoMenu opcao) throws FalhaBuscaException, FalhaCadastroException, FalhaDelecaoException, FalhaAtualizacaoException {

        switch (opcao) {
            case C: // CADASTRAR Agência
                viewCadastrarAgencia.load();
                break;

            case B: // BUSCAR por uma agência específica
                viewBuscarAgencia.load();
                break;

            case A: // ATUALIZAR os dados de uma agência
                viewAtualizarAgencia.load();
                break;

            case D: // DELETAR uma agência
                viewDeletarAgencia.load();
                break;

            case L: // LISTAR todas as agências
            /*  viewListarAgencias.load();*/
                break;

            case I: // IMPORTAR agências
            /*  viewImportarAgencias.load();*/
                break;

            case V: // VOLTAR ao menu principal
                break;

            default:
                System.out.println("\nOpção Inválida! Tente novamente informando uma opção válida!");
                break;
        }
    }

}
