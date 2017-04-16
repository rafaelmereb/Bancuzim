package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Menu;

public class ViewCadastrarCliente extends ViewGerenciarClientes implements ViewCadastrarInterface {

    public void load() {
        exibirMenu(Menu.CADASTRAR_CLIENTE);
        manterViewCadastrarCliente();
    }

    private void manterViewCadastrarCliente() {
        cadastrarCliente(colherDadosDeCliente());
    }

    /**
     * Confere a responsabilidade de salvar um cliente à service correspondente
     *
     * @param cliente a ser persistida
     */
    private void cadastrarCliente(Cliente cliente) {
        try {
            clienteService.salvarCliente(cliente);
        } catch (FalhaCadastroException falha) {
            System.out.println(falha.getMessage());
        }
    }

}
