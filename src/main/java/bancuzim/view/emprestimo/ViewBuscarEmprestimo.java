package bancuzim.view.emprestimo;

import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewBuscarInterface;
import bancuzim.util.Menu;

public class ViewBuscarEmprestimo extends ViewGerenciarEmprestimos implements ViewBuscarInterface{

    /**
     * "Carrega" a View responsável por buscar Empréstimos
     */
    public void load() {
        exibirMenu(Menu.BUSCAR_EMPRESTIMO);
        manterViewBuscarEmprestimo();
    }

    /**
     * Mantém a View responsável por buscar Empréstimos
     */
    private void manterViewBuscarEmprestimo() {
        try {
            exibirEmprestimo(buscarEmprestimo());
        } catch (FalhaBuscaException falha) {
            System.out.println(falha.getMessage());
        }
    }

}
