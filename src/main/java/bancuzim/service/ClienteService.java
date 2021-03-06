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

import static bancuzim.enums.Entidade.CLIENTE;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Persiste o cliente informado no banco de dados, caso não exista outra com mesmo CPF/CNPJ/nome
     *
     * @param cliente a ser persistido no banco de dados
     * @throws FalhaCadastroException caso o cadastrado encontre algum tipo de falha
     */
    public void salvarCliente(Cliente cliente) throws FalhaCadastroException {

        if (isNew(cliente)) {
            Cliente clienteSalvo = clienteRepository.save(cliente);

            if (clienteSalvo == null) {
                throw new FalhaCadastroException(CLIENTE, "Falha ao cadastrar cliente no banco!");
            } else if (clienteSalvo.getId().equals(cliente.getId())) {
                System.out.println("\n##### Cliente salvo com sucesso! #####");
            }

        } else throw new FalhaCadastroException(CLIENTE, "Já existe outro cliente com mesmo CPF/CNPJ!");
    }

    /**
     * Verifica se um determinado cliente é inexistente no banco de dados (dados não conflitam)
     *
     * @param cliente a ser verificado
     * @return se o cliente é novo
     */
    private boolean isNew(Cliente cliente) {

        if (isCpfCnpjInexistente(cliente.getCpfCnpj())) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se um determinado CPF/CNPJ é inexistente no banco de dados
     *
     * @param cpfCnpj a ser verificado
     * @return se o código já existe (false) ou não (true) no banco de dados
     */
    private boolean isCpfCnpjInexistente(String cpfCnpj) {
        boolean cpfCnpjInexistente = false;
        try {
            //Caso o código não exista, o método lançará uma exceção:
            buscarClientePorCpfCnpj(cpfCnpj);
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
            buscarClientesPorNome(nome);
        } catch (FalhaBuscaException e) {
            nomeInexistente = true;
        }
        return nomeInexistente;
    }

    /**
     * /**
     * Busca um cliente no banco de dados a partir do nome informado como referência
     *
     * @param nome a ser buscado no banco de dados
     * @return Lista de clientes com o nome indicado
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public List<Cliente> buscarClientesPorNome(String nome) throws FalhaBuscaException {

        List<Cliente> clienteBuscado = clienteRepository.findAllByNome(nome);
        if (clienteBuscado == null) {
            throw new FalhaBuscaException(CLIENTE, "Não há cliente com o nome informado");
        }
        return clienteBuscado;
    }

    /**
     * Busca um cliente no banco de dados a partir do CPF/CNPJ informado como referência
     *
     * @param cpfCnpj a ser persistida no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Cliente buscarClientePorCpfCnpj(String cpfCnpj) throws FalhaBuscaException {

        Cliente clienteBuscado = clienteRepository.findByCpfCnpj(cpfCnpj);
        if (clienteBuscado == null) {
            throw new FalhaBuscaException(CLIENTE, "Não há cliente com o cpf/cnpj informado!");
        }

        return clienteBuscado;
    }

    /**
     * Atualiza um cliente no banco de dados a partir de seus novos dados
     *
     * @param cliente a ser atualizado no banco de dados
     * @throws FalhaAtualizacaoException caso a atualização encontre algum tipo de falha
     */
    public void atualizarCliente(Cliente cliente) throws FalhaAtualizacaoException {

        Cliente clienteAtualizado = clienteRepository.save(cliente);
        if (!cliente.getId().equals(clienteAtualizado.getId())) {
            throw new FalhaAtualizacaoException(CLIENTE, "Não foi possível atualizar a cliente indicado!");
        }
    }

    /**
     * Deleta um cliente no banco de dados a partir do cpf/cnpj informado como referência
     *
     * @param cpfCnpj da cliente a ser deletada do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarClientePorCpfCnpj(String cpfCnpj) throws FalhaDelecaoException {

        try {
            buscarClientePorCpfCnpj(cpfCnpj);
            // Se o CPF/CNPJ informado não existir, a instrução acima lançará uma exceção que será capturada abaixo

            clienteRepository.deleteClienteByCpfCnpj(cpfCnpj);
            System.out.println("\n##### Cliente deletado com sucesso! #####");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(CLIENTE, "Não há cliente com o cpf/cnpj indicado!");
        }
    }

    /**
     * Retorna os clientes anteriormente persistidos no banco de dados
     *
     * @throws FalhaListagemException caso a listagem encontre algum tipo de falha
     */
    public ArrayList<Cliente> listarClientes() throws FalhaListagemException {

        ArrayList<Cliente> listaDeClientes = (ArrayList<Cliente>) converterIteravelEmLista(clienteRepository.findAll());

        if (listaDeClientes.isEmpty()) {
            throw new FalhaListagemException(CLIENTE, "Não há nenhum cliente a ser exibido!");
        }

        return listaDeClientes;
    }

    /**
     * Converte um iterável de clientes em uma lista de clientes
     *
     * @param iteravel que fornecerá os clientes
     * @return lista de clientes
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
