package bancuzim.service;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.exception.FalhaDelecaoException;
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
            throw new FalhaCadastroException(AGENCIA, e.getCause().getMessage());
        }
    }

    public Agencia buscarAgenciaPorNome(String nomeAgencia) throws FalhaBuscaException {

        Agencia agenciaBuscada;

        try {
             agenciaBuscada = agenciaRepository.findByNome(nomeAgencia);

            if (agenciaBuscada == null) { throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo nome informado!");}
        } catch (Exception e) {
            throw new FalhaBuscaException(AGENCIA, e.getCause().getMessage());
        }
        return agenciaBuscada;
    }

    public Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) throws FalhaBuscaException {
        Agencia agenciaBuscada;

        try {
            agenciaBuscada = agenciaRepository.findByCodigo(codigoAgencia);

            if (agenciaBuscada == null) { throw new FalhaBuscaException(AGENCIA, "Agência não encontrada pelo código informado!");}
        } catch (Exception e) {
            throw new FalhaBuscaException(AGENCIA, e.getCause().getMessage());
        }
        return agenciaBuscada;
    }

    public void deletarAgencia(Agencia agencia) throws FalhaDelecaoException {
        try {
            agenciaRepository.deleteAgenciaByCodigo(agencia.getCodigo());
        }catch (Exception e){
            throw new FalhaDelecaoException(AGENCIA, e.getCause().getMessage());
        }
    }
}
