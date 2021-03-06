package bancuzim.service;

import bancuzim.entity.Agencia;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static bancuzim.enums.Entidade.AGENCIA;

/**
 * Classe de serviço para a entidade Agencia, segundo anotação SpringBoot.
 * (Espera-se que aqui não seja feito nenhuma operação senão printar o resultado das operações e acionar os métodos de AgenciaRepository)
 */
@Service
@Transactional
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    /**
     * Persiste a agência informada no banco de dados, caso não exista outra com mesmo id/nome
     *
     * @param agencia a ser persistida no banco de dados
     * @throws FalhaCadastroException caso o cadastrado encontre algum tipo de falha
     */
    public void salvarAgencia(Agencia agencia) throws FalhaCadastroException {

        if (isNew(agencia)) {
            Agencia agenciaSalva = agenciaRepository.save(agencia);

            if (agenciaSalva == null) {
                throw new FalhaCadastroException(AGENCIA, "Falha ao cadastrar agência no banco!");
            } else if (agenciaSalva.getCodigo().equals(agencia.getCodigo())) {
                System.out.println("\n##### Agência salva com sucesso! #####");
            }

        }
    }

    /**
     * Verifica se uma determinada agência é inexistente no banco de dados (dados não conflitam)
     *
     * @param agencia a ser verificada
     * @return se a agencia é nova
     * @throws FalhaCadastroException caso ocorra uma falha no processo
     */
    private boolean isNew(Agencia agencia) throws FalhaCadastroException {

        if (isCodigoInexistente(agencia.getCodigo())) {
            if (isNomeInexistente(agencia.getNome())) {
                return true;
            } else throw new FalhaCadastroException(AGENCIA, "Já existe outra agência com mesmo Nome!");
        } else throw new FalhaCadastroException(AGENCIA, "Já existe outra agência com mesmo Código!");

    }

    /**
     * Verifica se um determinado codigo é inexistente no banco de dados
     *
     * @param codigo a ser verificado
     * @return se o código já existe (false) ou não (true) no banco de dados
     */
    private boolean isCodigoInexistente(Integer codigo) {
        boolean codigoInexistente = false;
        try {
            //Caso o código não exista, o método lançará uma exceção:
            buscarAgenciaPorCodigo(codigo);
        } catch (FalhaBuscaException e) {
            codigoInexistente = true;
        }
        return codigoInexistente;
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
            buscarAgenciaPorNome(nome);
        } catch (FalhaBuscaException e) {
            nomeInexistente = true;
        }
        return nomeInexistente;
    }

    /**
     * Busca uma agência no banco de dados a partir do nome informado como referência
     *
     * @param nomeAgencia a ser persistida no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Agencia buscarAgenciaPorNome(String nomeAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada = agenciaRepository.findByNome(nomeAgencia);
        if (agenciaBuscada == null) {
            throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo nome informado!");
        }
        return agenciaBuscada;
    }

    /**
     * Busca uma agência no banco de dados a partir do código informado como referência
     *
     * @param codigoAgencia a ser persistida no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada = agenciaRepository.findByCodigo(codigoAgencia);
        if (agenciaBuscada == null) {
            throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo código informado!");
        }
        return agenciaBuscada;
    }

    /**
     * Atualiza uma agência no banco de dados a partir de seus novos dados
     *
     * @param agencia a ser atualizada no banco de dados
     * @throws FalhaAtualizacaoException caso a busca encontre algum tipo de falha
     */
    public void atualizarAgencia(Agencia agencia) throws FalhaAtualizacaoException {
        Agencia agenciaAtualizada = agenciaRepository.save(agencia);

        if (!agencia.getCodigo().equals(agenciaAtualizada.getCodigo())) {
            throw new FalhaAtualizacaoException(AGENCIA, "Não foi possível atualizar a agência indicada!");
        }
    }

    /**
     * Deleta uma agência no banco de dados a partir do código informado como referência
     *
     * @param codigo da agência a ser deletada do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarAgenciaPorCodigo(Integer codigo) throws FalhaDelecaoException {

        try {
            // Se não houver agência com o código informado, uma FalhaBuscaException será lançada:
            buscarAgenciaPorCodigo(codigo);
            agenciaRepository.deleteAgenciaByCodigo(codigo);
            System.out.println("\n##### Agência deletada com sucesso! #####");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(AGENCIA, "Não há agência com o código informado!");
        }
    }

    /**
     * Deleta uma agência no banco de dados a partir do nome informado como referência
     *
     * @param nomeAgencia da agência a ser deletada do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarAgenciaPorNome(String nomeAgencia) throws FalhaDelecaoException {

        try {
            // Se não houver agência com o nome informado, uma FalhaBuscaException será lançada:
            buscarAgenciaPorNome(nomeAgencia);

            agenciaRepository.deleteAgenciaByNome(nomeAgencia);
            System.out.println("Agência removida com sucesso!");
        } catch (FalhaBuscaException e) {
            throw new FalhaDelecaoException(AGENCIA, "Não há agência com o nome informado!");
        }
    }

    /**
     * Retorna as agências anteriormente persistidas no banco de dados
     *
     * @throws FalhaListagemException caso a listagem encontre algum tipo de falha
     */
    public ArrayList<Agencia> listarAgencias() throws FalhaListagemException {

        ArrayList<Agencia> listaDeAgencias = (ArrayList<Agencia>) converterIteravelEmLista(agenciaRepository.findAll());

        if (listaDeAgencias.isEmpty()) {
            throw new FalhaListagemException(AGENCIA, "Não há nenhuma agência a ser exibida!");
        }

        return listaDeAgencias;
    }

    /**
     * Converte um iterável de agências em uma lista de agências
     *
     * @param iteravel que fornecerá as agências
     * @return lista de agências
     */
    private List<Agencia> converterIteravelEmLista(Iterable<Agencia> iteravel) {
        if (iteravel instanceof List) {
            return (List<Agencia>) iteravel;
        }
        List<Agencia> lista = new ArrayList<>();
        if (iteravel != null) {
            for (Agencia item : iteravel) {
                lista.add(item);
            }
        }
        return lista;
    }
}
