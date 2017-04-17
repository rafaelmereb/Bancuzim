package bancuzim.view.emprestimo;

import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.interfaces.ViewDeletarInterface;
import bancuzim.util.Menu;

public class ViewDeletarEmprestimo extends ViewGerenciarEmprestimos implements ViewDeletarInterface {

    /**
     * "Carrega" a view responsável por deletar Empréstimos
     */
    public void load() {
        exibirMenu(Menu.DELETAR_EMPRESTIMO);
        manterViewDeletarEmprestimo();
    }

    /**
     * Mantém a view responsável por deletar um Empréstimo
     */
    private void manterViewDeletarEmprestimo() {
        try {
            try {
                deletarEmprestimo(buscarEmprestimo().getCliente().getCpfCnpj());
            } catch (FalhaBuscaException e) {
                throw new FalhaDelecaoException(e.getEntidade(), e.getDescricaoFalha());
            }
        } catch (FalhaDelecaoException falha) {
            System.out.println(falha.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de deletar um empréstimo à service correspondente
     *
     * @param cpfCnpj CPF/CNPJ do Cliente responsável pelo empréstimo
     * @throws FalhaDelecaoException caso alguma falha ocorra no processo
     */
    private void deletarEmprestimo(String cpfCnpj) throws FalhaDelecaoException {
        emprestimoService.deletarEmprestimoPorCpfCnpjDoCliente(cpfCnpj);
    }
}
