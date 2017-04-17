package bancuzim.service;

import bancuzim.entity.Emprestimo;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static bancuzim.enums.Entidade.CLIENTE;
import static bancuzim.enums.Entidade.EMPRESTIMO;

@Service
@Transactional
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    /**
     * Persiste o emprestimo informado no banco de dados, caso não exista outra com mesmo CPF/CNPJ/nome
     *
     * @param emprestimo a ser persistido no banco de dados
     * @throws FalhaCadastroException caso o cadastrado encontre algum tipo de falha
     */
    public void salvarEmprestimo(Emprestimo emprestimo) throws FalhaCadastroException {

        if (isNew(emprestimo)) {
            Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

            if (emprestimoSalvo == null) {
                throw new FalhaCadastroException(EMPRESTIMO, "Falha ao cadastrar empréstimo no banco!");
            } else if (emprestimoSalvo.getId().equals(emprestimo.getId())) {
                System.out.println("\n##### Empréstimo salvo com sucesso! #####");
            }

        } else throw new FalhaCadastroException(CLIENTE, "Já existe outro emprestimo com mesmo CPF/CNPJ!");
    }

    /**
     * Verifica se um empréstimo é inexistente no banco de dados
     *
     * @param emprestimo a ser verificado
     * @return
     * @throws FalhaCadastroException
     */
    private boolean isNew(Emprestimo emprestimo) throws FalhaCadastroException {
        try {
            buscarEmprestimo(emprestimo.getCliente().getCpfCnpj());
            return false;
        } catch (FalhaBuscaException falha) {
            return true;
        }
    }

    /**
     * Busca um empréstimo no banco de dados a partir do cpfCnpj do cliente
     *
     * @param cpfCnpj do cliente que possui o empréstimo a ser buscado no banco de dados
     * @return empréstimo vinculado ao cliente com o cnpj indicado, caso o mesmo exista
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Emprestimo buscarEmprestimo(String cpfCnpj) throws FalhaBuscaException {
        if (cpfCnpj != null) {
            Emprestimo emprestimoBuscado = emprestimoRepository.findByCliente_CpfCnpj(cpfCnpj);
            if (emprestimoBuscado == null) {
                throw new FalhaBuscaException(EMPRESTIMO, "Não há empréstimo vinculado ao cliente indicado!");
            }
            return emprestimoBuscado;
        } else throw new FalhaBuscaException(EMPRESTIMO, "Não há referência de cliente para a busca!");
    }


    /**
     * Atualiza um empréstimo no banco de dados a partir de seus novos dados
     *
     * @param emprestimo a ser atualizado no banco de dados
     * @throws FalhaAtualizacaoException caso a atualização encontre algum tipo de falha
     */
    public void atualizarEmprestimo(Emprestimo emprestimo) throws FalhaAtualizacaoException {

        Emprestimo clienteAtualizado = emprestimoRepository.save(emprestimo);
        if (!emprestimo.getId().equals(clienteAtualizado.getId())) {
            throw new FalhaAtualizacaoException(CLIENTE, "Não foi possível atualizar a empréstimo indicado!");
        }
    }

    /**
     * Deleta um empréstimo de um cliente no banco de dados a partir do cpf/cnpj do cliente
     * TODO: Tentar remover apenas pelo id
     * @param cpfCnpj do cliente que possui o empréstimo a ser deletado do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarEmprestimoPorCpfCnpjDoCliente(String cpfCnpj) throws FalhaDelecaoException {

        try {
            Emprestimo emprestimo = buscarEmprestimo(cpfCnpj);
            emprestimo.getCliente().setEmprestimo(null);
            emprestimo.setCliente(null);
            emprestimoRepository.save(emprestimo);
            emprestimoRepository.delete(emprestimo.getId());
            System.out.println("\n##### Empréstimo deletado com sucesso! #####");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(CLIENTE, "Não há empréstimo vinculado ao cliente com o cpf/cnpj indicado!");
        }
    }

    /**
     * Retorna os empréstimos anteriormente persistidos no banco de dados
     *
     * @throws FalhaListagemException caso a listagem encontre algum tipo de falha
     */
    public ArrayList<Emprestimo> listarEmprestimos() throws FalhaListagemException {

        ArrayList<Emprestimo> listaDeClientes = (ArrayList<Emprestimo>) converterIteravelEmLista(emprestimoRepository.findAll());

        if (listaDeClientes.isEmpty()) {
            throw new FalhaListagemException(EMPRESTIMO, "Não há nenhum empréstimo a ser exibido!");
        }

        return listaDeClientes;
    }

    /**
     * Converte um iterável de empréstimos em uma lista de empréstimos
     *
     * @param iteravel que fornecerá os empréstimos
     * @return lista de empréstimos
     */
    private List<Emprestimo> converterIteravelEmLista(Iterable<Emprestimo> iteravel) {
        if (iteravel instanceof List) {
            return (List<Emprestimo>) iteravel;
        }
        ArrayList<Emprestimo> lista = new ArrayList<>();
        if (iteravel != null) {
            for (Emprestimo item : iteravel) {
                lista.add(item);
            }
        }
        return lista;
    }

}
