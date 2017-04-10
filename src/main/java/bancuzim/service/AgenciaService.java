package bancuzim.service;

import bancuzim.entity.Agencia;
import bancuzim.exception.*;
import bancuzim.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviço para a entidade Agencia, segundo anotação SpringBoot.
 * (Espera-se que aqui não seja feito nenhuma operação senão printar o resultado das operações e acionar os métodos de AgenciaRepository)
 * TODO: Mapeamento entre os métodos dessa classe e os métodos definidos na interface AgenciaRepository.
 * TODO: Lidar com as exceções solicitadas na atividade
 */
@Service
@Transactional
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;
    private final String AGENCIA = bancuzim.entity.Agencia.class.getSimpleName();

    /**
     * Persiste a agência informada no banco de dados, caso não exista outra com mesmo id/nome
     *
     * @param agencia a ser persistida no banco de dados
     * @throws FalhaCadastroException caso o cadastrado encontre algum tipo de falha
     */
    public void salvarAgencia(Agencia agencia) throws FalhaCadastroException {
        // if (buscarAgenciaPorCodigo(agencia.getCodigo()) == null){
        //   try {
        Agencia agenciaSalva = agenciaRepository.save(agencia);

        //       if (agenciaSalva == null) {
        //           throw new FalhaCadastroException(AGENCIA, "Falha ao cadastrar agência no banco!");
        //       }
        //   } catch (Exception e) {
        //        e.printStackTrace();
        //   }
        //} else throw new FalhaCadastroException(AGENCIA, "Já existe outra agência com o mesmo ID");
    }

    /**
     * Busca uma agência no banco de dados a partir do nome informado como referência
     *
     * @param nomeAgencia a ser persistida no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Agencia buscarAgenciaPorNome(String nomeAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada = null;

        // try {
        agenciaBuscada = agenciaRepository.findByNome(nomeAgencia);

        //     if (agenciaBuscada == null) {
        //         throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo nome informado!");
        //     }
        // } catch (Exception e) {
        //    e.printStackTrace();
        //}

        return agenciaBuscada;
    }

    /**
     * Busca uma agência no banco de dados a partir do código informado como referência
     *
     * @param codigoAgencia a ser persistida no banco de dados
     * @throws FalhaBuscaException caso a busca encontre algum tipo de falha
     */
    public Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada = null;

        //  try {
        agenciaBuscada = agenciaRepository.findByCodigo(codigoAgencia);

        //     if (agenciaBuscada == null) {
        //          throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo código informado!");
        //      }
        //  } catch (Exception e) {
        //     e.printStackTrace();
        // }

        return agenciaBuscada;
    }

    /**
     * Atualiza uma agência no banco de dados a partir de seus novos dados
     *
     * @param agencia a ser atualizada no banco de dados
     * @throws FalhaAtualizacaoException caso a busca encontre algum tipo de falha
     */
    public void atualizarAgencia(Agencia agencia) throws FalhaAtualizacaoException {
        //  try {
        Agencia agenciaAtualizada = agenciaRepository.save(agencia);

        //   if (!agencia.getCodigo().equals(agenciaAtualizada.getCodigo())){
        //       throw new FalhaAtualizacaoException(AGENCIA, "Não foi possível atualizar a agência indicada!");
        //    }
        //}catch (Exception e){
        //    e.printStackTrace();
        // }
    }

    /**
     * Deleta uma agência no banco de dados a partir do código informado como referência
     *
     * @param codigo da agência a ser deletada do banco de dados
     * @throws FalhaDelecaoException caso a deleção encontre algum tipo de falha
     */
    public void deletarAgenciaPorCodigo(Integer codigo) throws FalhaDelecaoException {
        try {
            agenciaRepository.delete(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FalhaDelecaoException(AGENCIA, "Falha ao deletar agência com o código informado!");
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
            agenciaRepository.deleteAgenciaByNome(nomeAgencia);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FalhaDelecaoException(AGENCIA, "Falha ao deletar agência com o nome informado!");
        }
    }

    /**
     * Retorna as agências anteriormente persistidas no banco de dados
     *
     * @throws FalhaListagemException caso a deleção encontre algum tipo de falha
     */
    public ArrayList<Agencia> listarAgencias() throws FalhaListagemException {
        ArrayList<Agencia> listaDeAgencias = (ArrayList<Agencia>) toList(agenciaRepository.findAll());

        //      if (listaDeAgencias.isEmpty()){
        //          throw new FalhaListagemException(AGENCIA, "Não há nenhuma agência a ser exibida!");
        //      }

        return listaDeAgencias;
    }

    /**
     * Converte um iterável de agências em uma lista de agências
     *
     * @param iteravel que fornecerá as agências
     * @return lista de agências
     */
    private List<Agencia> toList(Iterable<Agencia> iteravel) {
        if (iteravel instanceof List) {
            return (List<Agencia>) iteravel;
        }
        ArrayList<Agencia> lista = new ArrayList<Agencia>();
        if (iteravel != null) {
            for (Agencia item : iteravel) {
                lista.add(item);
            }
        }
        return lista;
    }
}
