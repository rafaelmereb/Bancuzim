package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.service.ClienteService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

import static bancuzim.enums.OpcaoMenu.*;

public class ViewGerenciarClientes extends ViewMenuPrincipal {

    @Autowired
    @Qualifier("clienteService")
    public ClienteService clienteService;
    @Autowired
    @Qualifier("viewCadastrarCliente")
    private ViewCadastrarCliente viewCadastrarCliente;
    @Autowired
    @Qualifier("viewImportarClientes")
    private ViewImportarClientes viewImportarClientes;
    @Autowired
    @Qualifier("viewListarClientes")
    private ViewListarClientes viewListarClientes;
    @Autowired
    @Qualifier("viewDeletarCliente")
    private ViewDeletarCliente viewDeletarCliente;
    @Autowired
    @Qualifier("viewAtualizarCliente")
    private ViewAtualizarCliente viewAtualizarCliente;
    @Autowired
    @Qualifier("viewBuscarCliente")
    private ViewBuscarCliente viewBuscarCliente;

    /**
     * "Carrega" a View responsável por Gerenciar operações referentes a Clientes
     */
    public void load() {
        manterViewGerenciarClientes();
    }

    /**
     * Mantém a View responsável por Gerenciar operações referentes a Clientes
     */
    private void manterViewGerenciarClientes() {
        OpcaoMenu opcao = CONTINUE;

        while (notVoltar(opcao)) {
            exibirMenu(Menu.GERENCIAR_CLIENTES);
            opcao = Leitura.lerOpcaoMenu();
            interpretarEntrada(opcao, viewCadastrarCliente, viewBuscarCliente, viewAtualizarCliente, viewDeletarCliente, viewListarClientes, viewImportarClientes);
        }
    }

    /**
     * Colhe dados do cliente a ser cadastrado
     *
     * @return cliente cujos dados foram colhidos
     */
    public Cliente colherDadosDeCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(Leitura.lerCampoStringObrigatorio("Nome da Cliente: "));
        cliente.setCpfCnpj(Leitura.lerCPFouCNPJvalido());
        cliente.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço do Cliente: "));
        cliente.setData_de_nascimento(Leitura.lerCampoDateObrigatorio("Data de nascimento do Cliente (AAAA-MM-DD): "));
        cliente.setSexo(Leitura.lerSexoObrigatorio());

        return cliente;
    }

    /**
     * Método responsável por buscar um cliente a partir dos dados de entrada do usuário
     *
     * @return agência buscada
     */
    public List<Cliente> buscarCliente() {
        return buscarClientePorReferencia(colherReferencia("CPF/CNPJ", "Nome"));
    }

    public List<Cliente> buscarClientePorReferencia(OpcaoMenu opcao) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        if (isA(opcao)) { // Parâmetro de busca: Código
             clientes.add(buscarClientePorCpfCnpj(colherCpfCnpjCliente()));
        } else { // Parâmetro de busca: Nome
            clientes = buscarClientesPorNome(colherNomeCliente());
        }
        return clientes;
    }

    /**
     * Escolhe o cliente desejado dentro de uma lista de clientes
     *
     * @param clientes a serem verificados
     * @return cliente desejado
     */
    public Cliente escolherClienteDesejado(List<Cliente> clientes) {
        if (clientes != null) {

            if (clientes.size() > 1) {
                System.out.println("\nHá mais de um cliente com o nome em questão! Seguem:\n");
                for (Cliente cliente : clientes) {
                    System.out.println(clientes.indexOf(cliente) + "º) " + cliente.toString());
                }

                boolean indexInvalido = false;
                Cliente clienteDesejado = null;
                do {
                    try {
                        clienteDesejado = clientes.get(Leitura.lerCampoIntegerObrigatorio("Escolha o índice do cliente para a operação desejada: "));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Índice inválido!");
                        indexInvalido = true;
                    }
                } while (indexInvalido);
                return clienteDesejado;
            } else return clientes.get(0);
        } else return null;
    }
    /**
     * Confere a responsabilidade de buscar um cliente a partir de seu CPF/CNPJ à service correspondente
     *
     * @param cpfCnpj utilizado como referência na busca
     * @return cliente com o código informado, caso o mesmo exista
     */
    public Cliente buscarClientePorCpfCnpj(String cpfCnpj) {
        Cliente cliente = null;
        try {
            cliente = clienteService.buscarClientePorCpfCnpj(cpfCnpj);
        } catch (FalhaBuscaException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    /**
     * Confere a responsabilidade de buscar clientes a partir de seu nome à service correspondente
     *
     * @param nomeCliente utilizado como referência na busca
     * @return clientes com o nome informado, caso o mesmo exista
     */
    public List<Cliente> buscarClientesPorNome(String nomeCliente) {
        List<Cliente> cliente = null;
        try {
            cliente = clienteService.buscarClientesPorNome(nomeCliente);
        } catch (FalhaBuscaException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    /**
     * Colhe o CPF/CNPJ do cliente desejado
     *
     * @return CPF/CNPJ do cliente desejado
     */
    public String colherCpfCnpjCliente() {
        return Leitura.lerCPFouCNPJvalido();
    }


    /**
     * Colhe o nome do cliente desejado
     *
     * @return nome do cliente desejado
     */
    public String colherNomeCliente() {
        return Leitura.lerCampoStringObrigatorio("Nome do cliente: ");
    }

    /**
     * Exibe a cliente buscado, caso o mesmo tenha sido encontrada
     *
     * @param cliente a ser exibido
     */
    public void exibirCliente(Cliente cliente) {
        if (cliente != null) {
            System.out.println(cliente.toString());
        }
    }


}
