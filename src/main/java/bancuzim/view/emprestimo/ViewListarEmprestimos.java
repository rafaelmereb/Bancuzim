package bancuzim.view.emprestimo;

import bancuzim.entity.Emprestimo;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.interfaces.ViewListarTodosInterface;
import bancuzim.util.Menu;

import java.util.ArrayList;

public class ViewListarEmprestimos extends ViewGerenciarEmprestimos implements ViewListarTodosInterface {

    /**
     * "Carrega" a View responsável por listar todas os Empréstimos salvos
     */
    public void load(){
        manterViewListarContas();
    }

    /**
     * Mantém a View responsável por listar os Empréstimos salvos
     */
    private void manterViewListarContas() {
        exibirMenu(Menu.LISTAR_EMPRESTIMOS);
        listarEmprestimos();
    }

    /**
     * Método responsável por listar os Empréstimos salvos
     */
    private void listarEmprestimos() {
        try {
            ArrayList<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();

            if (emprestimos.size() > 0) {
                for (Emprestimo emprestimo : emprestimos) {
                    exibirEmprestimo(emprestimo);
                }
            }
        } catch (FalhaListagemException falha) {
            System.out.println(falha.getMessage());
        }
    }
}
