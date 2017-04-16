package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewBuscarInterface;
import bancuzim.util.Menu;

import java.util.List;

public class ViewBuscarCliente extends ViewGerenciarClientes implements ViewBuscarInterface {

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
        List<Cliente> clientes = null;
        try {
            clientes = buscarCliente();

            if (clientes.size() > 1) {
                System.out.println("Há mais de um cliente com o nome indicado! Seguem:");
                for (Cliente cliente : clientes) {
                    exibirCliente(cliente);
                }
            } else exibirCliente(clientes.get(0));

        } catch (FalhaBuscaException falha) {
            System.out.println(falha.getMessage());
        }
    }
}
