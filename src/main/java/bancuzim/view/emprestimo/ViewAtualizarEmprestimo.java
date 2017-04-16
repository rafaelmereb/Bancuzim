package bancuzim.view.emprestimo;

import bancuzim.entity.Emprestimo;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewAtualizarInterface;
import bancuzim.util.Menu;

public class ViewAtualizarEmprestimo extends ViewGerenciarEmprestimos implements ViewAtualizarInterface {

    /**
     * "Carrega" a View responsável por atualizar Empréstimos
     */
    public void load() {
        exibirMenu(Menu.ATUALIZAR_EMPRESTIMO);
        manterViewAtualizarEmprestimo();
    }

    /**
     * Mantém a View responsável por atualizar Empréstimos
     */
    private void manterViewAtualizarEmprestimo() {
        try {
            try {
                atualizarDados(buscarEmprestimo(), colherDadosAtualizadosDeEmprestimo());
                System.out.println("Cliente atualizado com sucesso!");
            } catch (FalhaBuscaException e) {
                throw new FalhaAtualizacaoException(e.getEntidade(), e.getDescricaoFalha());
            }
        } catch (FalhaAtualizacaoException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Colhe os dados do empréstimo, atualizados
     *
     * @return empréstimo com os dados atualizados
     * @throws FalhaBuscaException caso o cliente vinculado não seja encontrado
     */
    private Emprestimo colherDadosAtualizadosDeEmprestimo() throws FalhaBuscaException {
        System.out.println("\n##### Digite os novos dados #####");
        return colherDadosDeEmprestimo();
    }

    /**
     * Atualiza os dados de um empréstimo a partir de novos dados coletados
     *
     * @param emprestimo           a ser atualizado
     * @param emprestimoAtualizado dados atualizados da emprestimo
     * @throws FalhaAtualizacaoException caso alguma falha ocorra no processo
     */
    private void atualizarDados(Emprestimo emprestimo, Emprestimo emprestimoAtualizado) throws FalhaAtualizacaoException {
        if (emprestimo != null) {

            //Setando os novos dados no registro já presente:
            emprestimo.setCliente(emprestimoAtualizado.getCliente());
            emprestimo.setTipo_emprestimo(emprestimoAtualizado.getTipo_emprestimo());
            emprestimo.setValor(emprestimoAtualizado.getValor());

            //Atualizando emprestimo:
            atualizarEmprestimo(emprestimo);
        }
    }

    /**
     * Confere a responsabilidade de atualizar um empréstimo específico à service correspondente
     *
     * @param emprestimo com os dados atualizados
     * @throws FalhaAtualizacaoException caso alguma falha ocorra no processo
     */
    private void atualizarEmprestimo(Emprestimo emprestimo) throws FalhaAtualizacaoException {
        emprestimoService.atualizarEmprestimo(emprestimo);
    }
}
