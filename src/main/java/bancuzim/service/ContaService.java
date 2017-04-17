package bancuzim.service;

import bancuzim.entity.Agencia;
import bancuzim.entity.Conta;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static bancuzim.enums.Entidade.CONTA;

@Service
@Transactional
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    /**
     * Persiste a conta informada no banco de dados, caso não exista outra com mesmo CPF/CNPJ/nome
     *
     * @param conta a ser salva no banco de dados
     */
    public void salvarConta(Conta conta) throws FalhaCadastroException {
        if (isNew(conta)) {
            Conta contaSalva = contaRepository.save(conta);

            if (contaSalva == null) {
                throw new FalhaCadastroException(CONTA, "Falha ao cadastrar Conta no banco!");
            } else if (contaSalva.getId().equals(conta.getId())) {
                System.out.println("\n##### Conta cadastrada com sucesso! #####");
            }
        } else throw new FalhaCadastroException(CONTA, "Já existe outra conta com mesmo número na agência indicada!");
    }

    /**
     * Verifica se uma determinada conta é inexistente no banco de dados (dados não conflitam)
     *
     * @param conta a ser verificada
     * @return
     */
    private boolean isNew(Conta conta) {
        if (isNumeroDaContaInexistenteNaAgencia(conta.getNumero(), conta.getAgencia())) {
            return true;
        }
        return false;
    }


    private boolean isNumeroDaContaInexistenteNaAgencia(String numero, Agencia agencia) {
        try {
            //Caso não exista o número da conta com a agência informada, o método lançará uma exceção:
            buscarConta(numero, agencia);
            return false;
        } catch (FalhaBuscaException falha) {
            return true;
        }
    }

    /**
     * Busca uma conta no banco de dados a partir do numero da conta e a agência vinculada informados como referência
     *
     * @param numeroConta a ser buscada
     * @param agencia     vinculada ao numeroConta informado
     * @return conta desejada, caso a mesma seja encontrada
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Conta buscarConta(String numeroConta, Agencia agencia) throws FalhaBuscaException {

        Conta contaBuscada = contaRepository.findContaByNumeroAndAgencia(numeroConta, agencia);
        if (contaBuscada == null) {
            throw new FalhaBuscaException(CONTA, "Não há conta com o número/agência informados!");
        }
        return contaBuscada;
    }


    /**
     * Atualiza uma conta do banco de dados a partir de seus novos dados
     *
     * @param conta com os dados atualizados
     * @throws FalhaAtualizacaoException caso a atualização encontre algum tipo de falha
     */
    public void atualizarConta(Conta conta) throws FalhaAtualizacaoException {
        Conta contaAtualizada = contaRepository.save(conta);
        if (!conta.getId().equals(contaAtualizada.getId())) {
            throw new FalhaAtualizacaoException(CONTA, "Não foi possível atualizar a cliente indicado!");
        }
    }

    /**
     * Deleta uma conta do banco de dados a partir da agência e número da conta correspondentes
     * TODO: Tentar remover apenas pelo id
     * @param numeroDaConta a ser deletada
     * @param agencia pelo qual pertence a conta
     */
    public void deletarConta(String numeroDaConta, Agencia agencia) throws FalhaDelecaoException {
        try {
            Conta conta = buscarConta(numeroDaConta, agencia);
            conta.getAgencia().getContas().remove(conta);
            conta.setAgencia(null);
            conta.getCliente().getContas().remove(conta);
            conta.setCliente(null);
            contaRepository.save(conta);
            contaRepository.delete(conta.getId());
           // contaRepository.deleteContaByNumeroAndAgencia(numeroDaConta, agencia);
            System.out.println("Conta deletada com sucesso!");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(e.getEntidade(), e.getDescricaoFalha());
        }
    }

    /**
     * Retorna as contas anteriormente persistidas no banco de dados
     *
     * @throws FalhaListagemException caso a listagem encontre algum tipo de falha
     */
    public ArrayList<Conta> listarContas() throws FalhaListagemException {
        ArrayList<Conta> listaDeContas = (ArrayList<Conta>) converterIteravelEmLista(contaRepository.findAll());

        if (listaDeContas.isEmpty()) {
            throw new FalhaListagemException(CONTA, "Não há nenhuma conta a ser exibida!");
        }

        return listaDeContas;
    }

    /**
     * Converte um iterável de contas em uma lista de contas
     *
     * @param iteravel que fornecerá as contas
     * @return lista de contas
     */
    private List<Conta> converterIteravelEmLista(Iterable<Conta> iteravel) {
        if (iteravel instanceof List) {
            return (List<Conta>) iteravel;
        }
        List<Conta> lista = new ArrayList<>();
        if (iteravel != null) {
            for (Conta item : iteravel) {
                lista.add(item);
            }
        }
        return lista;
    }
}
