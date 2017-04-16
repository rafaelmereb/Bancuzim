package bancuzim.view.conta;

import bancuzim.entity.Agencia;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.interfaces.ViewDeletarInterface;
import bancuzim.util.Menu;

public class ViewDeletarConta  extends ViewGerenciarContas implements ViewDeletarInterface{

    /**
     * "Carrega" a view responsável por deletar contas
     */
    public void load() {
        exibirMenu(Menu.DELETAR_CONTA);
        manterViewDeletarConta();
    }

    /**
     * Mantém a view responsável por deletar uma conta
     */
    private void manterViewDeletarConta() {
        try{
            try {
                deletarConta(colherNumeroDaConta(), colherAgencia());
            } catch (FalhaBuscaException falha) {
                throw new FalhaDelecaoException(falha.getEntidade(), falha.getDescricaoFalha());
            }
        } catch (FalhaDelecaoException falha){
            System.out.println(falha.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de deletar uma conta à service correspondente
     *
     * @param numeroDaConta a ser deletada da agência em questão
     * @param agencia agencia que possui a conta a ser deletada
     */
    private void deletarConta(String numeroDaConta, Agencia agencia) throws FalhaDelecaoException{
        contaService.deletarConta(numeroDaConta, agencia);
    }
}
