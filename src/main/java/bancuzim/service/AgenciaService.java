package bancuzim.service;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaAtualizacaoException;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    private final String AGENCIA = Agencia.class.getSimpleName();

    public void salvarAgencia(Agencia agencia) throws FalhaCadastroException {
        try {
            Agencia agenciaSalva = agenciaRepository.save(agencia);

            if (agenciaSalva == null) {
                throw new FalhaCadastroException(AGENCIA, "Falha ao cadastrar agência no banco!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Agencia buscarAgenciaPorNome(String nomeAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada = null;

        try {
             agenciaBuscada = agenciaRepository.findByNome(nomeAgencia);

            if (agenciaBuscada == null) {
                throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo nome informado!");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return agenciaBuscada;
    }

    public Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada = null;

        try {
            agenciaBuscada = agenciaRepository.findByCodigo(codigoAgencia);

            if (agenciaBuscada == null) {
                throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo código informado!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return agenciaBuscada;
    }


    public void atualizarAgencia(Agencia agencia) throws FalhaAtualizacaoException {
        try {
            Agencia agenciaAtualizada = agenciaRepository.save(agencia);

            if (!agencia.getCodigo().equals(agenciaAtualizada.getCodigo())){
                throw new FalhaAtualizacaoException(AGENCIA, "Não foi possível atualizar a agência indicada!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletarAgenciaPorCodigo(Integer codigo) {
        try {
            agenciaRepository.delete(codigo);

            //throw new FalhaDelecaoException(AGENCIA, "Falha ao deletar agência!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void deletarAgenciaPorNome(String nomeAgencia){
        try {
            agenciaRepository.deleteAgenciaByNome(nomeAgencia);

            //throw new FalhaDelecaoException(AGENCIA, "Falha ao deletar agência!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
