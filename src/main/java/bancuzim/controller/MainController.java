package bancuzim.controller;

import bancuzim.enums.OpcaoMenu;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.*;

@Component
public class MainController implements CommandLineRunner {

    private Logger log = Logger.getLogger(MainController.class);


    @Override
    public void run(String... args) throws Exception {

        try (Scanner entrada = new Scanner(System.in)) {
            OpcaoMenu opcaoEscolhida = CONTINUE;
            log.warn(Menu.INICIAL);

            /* Enquanto a opção escolhida não for S (SAIR),
            solicitar entrada do usuário: */
            while(!opcaoEscolhida.equals(S)){
                opcaoEscolhida = valueOf(entrada.nextLine());
                switch (opcaoEscolhida){
                    case A:
                        AgenciaService agenciaService = new AgenciaService();
                        break;
                }
            }
        }
    }
}