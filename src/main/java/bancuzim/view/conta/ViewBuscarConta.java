package bancuzim.view.conta;

import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewBuscarInterface;
import bancuzim.util.Menu;

public class ViewBuscarConta extends ViewGerenciarContas implements ViewBuscarInterface{

    /**
     * "Carrega" a View responsável por buscar clientes
     */
    public void load() {
        exibirMenu(Menu.BUSCAR_CONTA);
        manterViewBuscarConta();
    }

    /**
     * Mantém a View responsável por buscar clientes
     */
    private void manterViewBuscarConta() {
        try {
            exibirConta(buscarConta());
        } catch (FalhaBuscaException falha) {
            System.out.println(falha.getMessage());
        }
    }

}
