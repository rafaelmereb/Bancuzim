package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;

public class ViewCadastrarCliente extends ViewGerenciarClientes implements ViewCadastrarInterface{

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

    private Cliente colherDadosDeCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(Leitura.lerCampoStringObrigatorio("Nome do Cliente: "));
        cliente.setCpfCnpj(Leitura.lerCampoStringObrigatorio("CPF/CNPJ da Agência: "));
        cliente.setData_de_nascimento(Leitura.lerCampoDateObrigatorio("Data de nascimento (AAAA-MM-DD): "));
        cliente.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço da Agência: "));

        return cliente;
    }
}