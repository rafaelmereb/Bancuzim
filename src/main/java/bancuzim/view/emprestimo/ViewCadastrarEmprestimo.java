package bancuzim.view.emprestimo;

import bancuzim.entity.Emprestimo;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Menu;

public class ViewCadastrarEmprestimo extends ViewGerenciarEmprestimos implements ViewCadastrarInterface {

    /**
     * "Carrega" a view responsável por cadastrar clientes
     */
    public void load() {
        exibirMenu(Menu.CADASTRAR_CLIENTE);
        manterViewCadastrarEmprestimo();
    }

    private void manterViewCadastrarEmprestimo() {
        try {
            try {
                cadastrarEmprestimo(colherDadosDeEmprestimo());
            } catch (FalhaBuscaException falha) {
                throw new FalhaCadastroException(falha.getEntidade(), falha.getDescricaoFalha());
            }
        } catch (FalhaCadastroException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de salvar um cliente à service correspondente
     *
     * @param cliente a ser persistida
     */
    private void cadastrarEmprestimo(Emprestimo cliente) throws FalhaCadastroException {
        emprestimoService.salvarEmprestimo(cliente);
    }
}
