package bancuzim.service;

import bancuzim.repository.AgenciaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
/**
 * Classe de serviço para a entidade Agencia, segundo anotação SpringBoot.
 * (Espera-se que aqui não seja feito nenhuma operação senão printar o resultado das operações e acionar os métodos de AgenciaRepository)
 * TODO: Mapeamento entre os métodos dessa classe e os métodos definidos na interface AgenciaRepository.
 */
public class AgenciaService implements CommandLineRunner {

    @Autowired
    private AgenciaRepository agenciaRepository;

    private Logger log;


    public AgenciaService() {
        log = Logger.getLogger(AgenciaService.class);
    }

    /**
     * Run da interface CommandLineRunner
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {


    }


}
