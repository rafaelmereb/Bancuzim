package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.service.ClienteService;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

import static bancuzim.enums.Entidade.CLIENTE;
import static bancuzim.enums.OpcaoMenu.*;
import static bancuzim.util.Leitura.*;

public class ViewGerenciarClientes extends ViewMenuPrincipal {

    @Autowired
    @Qualifier("clienteService")
    ClienteService clienteService;
    @Autowired
    @Qualifier("viewCadastrarCliente")
    ViewCadastrarCliente viewCadastrarCliente;
    @Autowired
    @Qualifier("viewImportarClientes")
    ViewImportarClientes viewImportarClientes;
    @Autowired
    @Qualifier("viewListarClientes")
    ViewListarClientes viewListarClientes;
    @Autowired
    @Qualifier("viewDeletarCliente")
    ViewDeletarCliente viewDeletarCliente;
    @Autowired
    @Qualifier("viewAtualizarCliente")
    ViewAtualizarCliente viewAtualizarCliente;
    @Autowired
    @Qualifier("viewBuscarCliente")
    ViewBuscarCliente viewBuscarCliente;

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
            opcao = lerOpcaoMenu();
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

        cliente.setNome(lerCampoStringObrigatorio("Nome do Cliente: "));
        cliente.setCpfCnpj(lerCPFouCNPJvalido());
        cliente.setEndereco(lerCampoStringObrigatorio("Endereço do Cliente: "));
        cliente.setData_de_nascimento(lerCampoDateObrigatorio("Data de nascimento do Cliente (AAAA-MM-DD): "));
        cliente.setSexo(lerSexoObrigatorio());

        return cliente;
    }

    /**
     * Método responsável por buscar um cliente a partir dos dados de entrada do usuário
     *
     * @return agência buscada
     */
    public List<Cliente> buscarClientes() throws FalhaBuscaException {
        return buscarClientesPorReferencia(colherReferenciaEntreDuasOpcoes("CPF/CNPJ", "Nome"));
    }

    /**
     * Redireciona a busca segundo a referência/opção adotada (nome ou CPF/CNPJ)
     *
     * @param opcao escolhida pelo usuário
     * @return lista de clientes contendo o resultado da busca
     * @throws FalhaBuscaException caso alguma falha ocorra no processo
     */
    public List<Cliente> buscarClientesPorReferencia(OpcaoMenu opcao) throws FalhaBuscaException {
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
    public Cliente escolherClienteDesejado(List<Cliente> clientes) throws FalhaBuscaException {
        if (clientes != null) {

            if (clientes.size() == 0){
                throw new FalhaBuscaException(CLIENTE, "Não foi encontrado nenhum cliente com a informação fornecida!");
            }

            if (clientes.size() == 1){
                return clientes.get(0);
            }

            if (clientes.size() > 1) {
                System.out.println("\nHá mais de um cliente com o nome em questão! Seguem:\n");
                for (Cliente cliente : clientes) {
                    System.out.println( (clientes.indexOf(cliente) + 1) + "º) " + cliente.toString());
                    // O acréscimo é para que os itens listados não comecem com índice 0.
                }

                boolean indexInvalido = false;
                Cliente clienteDesejado = null;
                do {
                    try {
                        clienteDesejado = clientes.get(lerCampoIntegerObrigatorio("Escolha o índice do cliente para a operação desejada: ") - 1);
                        // O decréscimo é para compensar o acréscimo imposto anteriormente

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Índice inválido!");
                        indexInvalido = true;
                    }
                } while (indexInvalido);
                return clienteDesejado;
            }
        }

        return null;
    }
    /**
     * Confere a responsabilidade de buscar um cliente a partir de seu CPF/CNPJ à service correspondente
     *
     * @param cpfCnpj utilizado como referência na busca
     * @return cliente com o código informado, caso o mesmo exista
     */
    public Cliente buscarClientePorCpfCnpj(String cpfCnpj) throws FalhaBuscaException {
        return clienteService.buscarClientePorCpfCnpj(cpfCnpj);
    }

    /**
     * Confere a responsabilidade de buscar clientes a partir de seu nome à service correspondente
     *
     * @param nomeCliente utilizado como referência na busca
     * @return clientes com o nome informado, caso o mesmo exista
     */
    public List<Cliente> buscarClientesPorNome(String nomeCliente) throws FalhaBuscaException {
        return clienteService.buscarClientesPorNome(nomeCliente);
    }

    /**
     * Colhe o CPF/CNPJ do cliente desejado
     *
     * @return CPF/CNPJ do cliente desejado
     */
    public String colherCpfCnpjCliente() {
        return lerCPFouCNPJvalido();
    }


    /**
     * Colhe o nome do cliente desejado
     *
     * @return nome do cliente desejado
     */
    public String colherNomeCliente() {
        return lerCampoStringObrigatorio("Nome do cliente: ");
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
