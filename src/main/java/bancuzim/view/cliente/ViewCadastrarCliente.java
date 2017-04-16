package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Menu;

public class ViewCadastrarCliente extends ViewGerenciarClientes implements ViewCadastrarInterface {

    /**
     * "Carrega" a view responsável por cadastrar clientes
     */
    public void load() {
        exibirMenu(Menu.CADASTRAR_CLIENTE);
        manterViewCadastrarCliente();
    }

    /**
     * Mantém a view responsável por cadastrar clientes
     */
    private void manterViewCadastrarCliente() {

        try {
            cadastrarCliente(colherDadosDeCliente());
        } catch (FalhaCadastroException falha) {
            System.out.println(falha.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de salvar um cliente à service correspondente
     *
     * @param cliente a ser persistida
     * @throws FalhaCadastroException caso alguma falha ocorra no processo
     */
    private void cadastrarCliente(Cliente cliente) throws FalhaCadastroException {
        clienteService.salvarCliente(cliente);
    }

}
