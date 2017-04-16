package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.interfaces.ViewListarTodosInterface;
import bancuzim.util.Menu;

import java.util.ArrayList;

public class ViewListarClientes extends ViewGerenciarClientes implements ViewListarTodosInterface {

    /**
     * "Carrega" a View responsável por listar todas os clientes salvos
     */
    public void load() {
        manterViewListarAgencias();
    }

    /**
     * Mantém a View responsável por listar os clientes salvos
     */
    private void manterViewListarAgencias() {
        exibirMenu(Menu.LISTAR_AGENCIAS);
        listarAgencias();
    }

    /**
     * Método responsável por listar os clientes salvas
     */
    private void listarAgencias() {
        try {
            ArrayList<Cliente> clientes = clienteService.listarClientes();

            if (clientes.size() > 0) {
                for (Cliente cliente : clientes) {
                    exibirCliente(cliente);
                }
            }
        } catch (FalhaListagemException falha) {
            System.out.println(falha.getMessage());
        }
    }
}


