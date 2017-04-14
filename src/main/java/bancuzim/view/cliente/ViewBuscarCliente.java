package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.interfaces.ViewBuscarInterface;
import bancuzim.util.Menu;

public class ViewBuscarCliente extends ViewGerenciarClientes implements ViewBuscarInterface{

    /**
     * "Carrega" a View responsável por buscar clientes
     */
    public void load() {
        exibirMenu(Menu.BUSCAR_CLIENTE);
        manterViewBuscarCliente();
    }

    /**
     * Mantém a View responsável por buscar clientes
     */
    private void manterViewBuscarCliente() {
        exibirCliente(buscarCliente());
    }

    private void exibirCliente(Cliente cliente) {
    }

    private Cliente buscarCliente() {
        return null;
    }

}
