package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.interfaces.ViewDeletarInterface;
import bancuzim.util.Menu;

public class ViewDeletarAgencia extends ViewGerenciarAgencias implements ViewDeletarInterface{

    private final String AGENCIA = Agencia.class.getSimpleName();

    /**
     * "Carrega" a View responsável por deletar agências
     */
    public void load(){
        exibirMenu(Menu.DELETAR_AGENCIA);
        manterViewDeletarAgencia();
    }

    /**
     * Mantém a View responsável por deletar agências
     */
    private void manterViewDeletarAgencia(){
        deletarAgenciaSegundoReferencia(colherReferencia("Código", "Nome"));
    }

    /**
     * Redireciona a forma de deleção a partir da referência escolhida pelo usuário (nome ou código)
     * @param opcaoMenu correspondente à referência escolhida pelo usuário para futura deleção
     */
    private void deletarAgenciaSegundoReferencia(OpcaoMenu opcaoMenu){
        switch (opcaoMenu){
            case A:
                deletarAgenciaPorCodigo(colherCodigoAgencia());
                break;
            case B:
                deletarAgenciaPorNome(colherNomeAgencia());
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
