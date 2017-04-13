package bancuzim.service;

import bancuzim.entity.Cliente;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    private final String CLIENTE = bancuzim.entity.Cliente.class.getSimpleName();

    /**
     * Persiste o cliente informado no banco de dados, caso não exista outra com mesmo id/nome
     *
     * @param cliente a ser persistido no banco de dados
     * @throws FalhaCadastroException caso o cadastrado encontre algum tipo de falha
     */
    public void salvarAgencia(Cliente cliente) throws FalhaCadastroException {

        if (isNew(cliente)) {
            Cliente clienteSalvo = clienteRepository.save(cliente);

            if (clienteSalvo == null) {
                throw new FalhaCadastroException(CLIENTE, "Falha ao cadastrar cliente no banco!");
            } else if (clienteSalvo.getCpfCnpj().equals(cliente.getCpfCnpj())){
                System.out.println("cliente salva com sucesso!");
            }

        }
    }

    /**
     * Verifica se um determinado cliente é inexistente no banco de dados (dados não conflitam)
     *
     * @param cliente a ser verificado
     * @return se o cliente é novo
     * @throws FalhaCadastroException caso ocorra uma falha no processo
     */
    private boolean isNew(Cliente cliente) throws FalhaCadastroException {

        if (isCpfCnpjInexistente(cliente.getCpfCnpj())) {
            if (isNomeInexistente(cliente.getNome())) {
                return true;
            } else throw new FalhaCadastroException(CLIENTE, "Já existe outra cliente com mesmo Nome!");
        } else throw new FalhaCadastroException(CLIENTE, "Já existe outra cliente com mesmo Código!");

    }

    /**
     * Verifica se um determinado cpf_cnpj é inexistente no banco de dados
     *
     * @param cpf_cnpj a ser verificado
     * @return se o código já existe (false) ou não (true) no banco de dados
     */
    private boolean isCpfCnpjInexistente(String cpf_cnpj){
        boolean cpfCnpjInexistente = false;
        try {
            //Caso o código não exista, o método lançará uma exceção:
            buscarClientePorCpfCnpj(cpf_cnpj);
        } catch (FalhaBuscaException e) {
            cpfCnpjInexistente = true;
        }
        return cpfCnpjInexistente;
    }

    /**
     * Verifica se um determinado nome é inexistente no banco de dados
     *
     * @param nome a ser verificado
     * @return se o nome já existe (false) ou não (true) no banco de dados
     */
    private boolean isNomeInexistente(String nome) {
        boolean nomeInexistente = false;
        try {
            //Caso o nome não exista, o método lançará uma exceção:
            buscarClientePorNome(nome);
        } catch (FalhaBuscaException e) {
            nomeInexistente = true;
        }
        return nomeInexistente;
    }

    /**
     * Busca um cliente no banco de dados a partir do nome informado como referência
     *
     * @param nome a ser buscado no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Cliente buscarClientePorNome(String nome) throws FalhaBuscaException {

        Cliente clienteBuscado = clienteRepository.findByNome(nome);
        if (clienteBuscado == null) {
            throw new FalhaBuscaException(CLIENTE, "Não há cliente com o nome informado");
        }
        return clienteBuscado;
    }

    /**
     * Busca um cliente no banco de dados a partir do cpf/cnpj informado como referência
     *
     * @param cpf_cnpj a ser persistida no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Cliente buscarClientePorCpfCnpj(String cpf_cnpj) throws FalhaBuscaException {

        Cliente clienteBuscado = clienteRepository.findByCpfCnpj(cpf_cnpj);
        if (clienteBuscado == null) {
            throw new FalhaBuscaException(CLIENTE, "Não há cliente com o cpf/cnpj informado!");
        }

        return clienteBuscado;
    }

    /**
     * Atualiza um cliente no banco de dados a partir de seus novos dados
     *
     * @param cliente a ser atualizado no banco de dados
     * @throws FalhaAtualizacaoException caso a busca encontre algum tipo de falha
     */
    public void atualizarCliente(Cliente cliente) throws FalhaAtualizacaoException {
        Cliente clienteAtualizado = clienteRepository.save(cliente);

        if (!cliente.getCpfCnpj().equals(clienteAtualizado.getCpfCnpj())) {
            throw new FalhaAtualizacaoException(CLIENTE, "Não foi possível atualizar a cliente indicada!");
        }
    }

    /**
     * Deleta um cliente no banco de dados a partir do cpf/cnpj informado como referência
     *
     * @param cpf_cnpj da cliente a ser deletada do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarClientePorCpfCnpj(String cpf_cnpj) throws FalhaDelecaoException {

        try {
            buscarClientePorCpfCnpj(cpf_cnpj);
            // Como a busca acima lançará uma exceção, somente lançaremos a exceção abaixo se o documento não foi deletado.

            clienteRepository.deleteClienteByCpfCnpj(cpf_cnpj);
            System.out.println("Cliente removido com sucesso!");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(CLIENTE, "Não há cliente com o cpf/cnpj indicado!");
        }
    }

    /**
     * Deleta um cliente no banco de dados a partir do nome informado como referência
     *
     * @param nomeCliente do cliente a ser deletada do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarClientePorNome(String nomeCliente) throws FalhaDelecaoException {


        try {
            // Se não houver agência com o nome informado, uma FalhaBuscaException será lançada:
            buscarClientePorNome(nomeCliente);

            clienteRepository.deleteClienteByNome(nomeCliente);
            System.out.println("Cliente removido com sucesso!");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(CLIENTE, "Não há cliente com o nome indicado!");
        }
    }

    /**
     * Retorna os clientes anteriormente persistidos no banco de dados
     *
     * @throws FalhaListagemException caso a deleção encontre algum tipo de falha
     */
    public ArrayList<Cliente> listarClientes() throws FalhaListagemException {

        ArrayList<Cliente> listaDeClientes = (ArrayList<Cliente>) converterIteravelEmLista(clienteRepository.findAll());

        if (listaDeClientes.isEmpty()) {
            throw new FalhaListagemException(CLIENTE, "Não há nenhum cliente a ser exibida!");
        }

        return listaDeClientes;
    }

    /**
     * Converte um iterável de agências em uma lista de agências
     *
     * @param iteravel que fornecerá as agências
     * @return lista de agências
     */
    private List<Cliente> converterIteravelEmLista(Iterable<Cliente> iteravel) {
        if (iteravel instanceof List) {
            return (List<Cliente>) iteravel;
        }
        ArrayList<Cliente> lista = new ArrayList<>();
        if (iteravel != null) {
            for (Cliente item : iteravel) {
                lista.add(item);
            }
        }
        return lista;
    }
}
