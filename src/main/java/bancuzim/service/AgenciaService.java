package bancuzim.service;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.repository.AgenciaRepository;
import org.apache.log4j.Logger;
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
public class AgenciaService{

    @Autowired
    private AgenciaRepository agenciaRepository;

    private Logger log = Logger.getLogger(AgenciaService.class);

    public void salvarAgencia(Agencia agencia) throws FalhaCadastroException {

        try {
            Agencia agenciaSalva = agenciaRepository.save(agencia);

            if (agenciaSalva != null) {
                log.warn("Agência cadastrada com sucesso!");
            }
        } catch (Exception e) {
            throw new FalhaCadastroException("Falha ao cadastrar agência!", e);
        }
    }

}
