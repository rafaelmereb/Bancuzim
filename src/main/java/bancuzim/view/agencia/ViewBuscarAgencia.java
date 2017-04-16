package bancuzim.view.agencia;

import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewBuscarInterface;
import bancuzim.util.Menu;

public class ViewBuscarAgencia extends ViewGerenciarAgencias implements ViewBuscarInterface{

    /**
     * "Carrega" a View responsável por buscar agências
     */
    public void load(){
        exibirMenu(Menu.BUSCAR_AGENCIA);
        manterViewBuscarAgencia();
    }

    /**
     * Mantém a View responsável por buscar agências
     */
    private void manterViewBuscarAgencia() {
        try {
            exibirAgencia(buscarAgencia());
        } catch (FalhaBuscaException falha) {
            System.out.println(falha.getMessage());
        }
    }

}
