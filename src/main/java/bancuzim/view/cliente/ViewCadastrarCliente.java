package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Leitura;
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
        } catch (FalhaCadastroException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente colherDadosDeCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(Leitura.lerCampoStringObrigatorio("Nome do Cliente: "));
        cliente.setCpfCnpj(Leitura.lerCPFouCNPJvalido());
        cliente.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço do Cliente: "));
        cliente.setData_de_nascimento(Leitura.lerCampoDateObrigatorio("Data de nascimento (AAAA-MM-DD): "));
        cliente.setSexo(Leitura.lerSexoObrigatorio());

        return cliente;
    }
}
