package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.util.Menu;

import java.util.Scanner;

public class ViewDeletarAgencia extends ViewAgencia{

    private final String AGENCIA = Agencia.class.getSimpleName();

    void load(){
        exibirMenu(Menu.DELETAR_AGENCIA);
        deletarAgencia();
    }

    /**
     * Método encarregado por
     */
    private void deletarAgencia(){
        deletarAgenciaSegundoReferencia(colherReferenciaParaBusca());
    }

    /**
     * Redireciona a forma de deleção a partir da referência escolhida pelo usuário (nome ou código)
     * @param opcaoMenu correspondente à referência escolhida para deleção pelo usuário
     */
    private void deletarAgenciaSegundoReferencia(OpcaoMenu opcaoMenu){
        Scanner leitor = new Scanner(System.in);
        switch (opcaoMenu){
            case A:
                deletarAgenciaPorNome(colherNomeAgencia());
                break;
            case B:
                deletarAgenciaPorCodigo(colherCodigoAgencia());
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    /**
     * Confere a responsabilidade de deletar uma agência pelo seu respectivo código à service correspondente
     * @param codigo utilizado como referência para a deleção
     */
    private void deletarAgenciaPorCodigo(Integer codigo){
        try {
            agenciaService.deletarAgenciaPorCodigo(codigo);
        } catch (FalhaDelecaoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de deletar uma agência pelo seu respectivo nome à service correspondente
     * @param nome utilizado como referência para a deleção
     */
    private void deletarAgenciaPorNome(String nome){
        try {
            agenciaService.deletarAgenciaPorNome(nome);
        } catch (FalhaDelecaoException e) {
            System.out.println(e.getMessage());
        }
    }


}
