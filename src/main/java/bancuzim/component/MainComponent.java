package bancuzim.component;

import bancuzim.enums.OpcaoMenu;
import bancuzim.util.Menu;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.*;

@Component
public class MainComponent implements CommandLineRunner {

    private Logger log = Logger.getLogger(MainComponent.class);


    @Override
    public void run(String... args) throws Exception {

        try (Scanner entrada = new Scanner(System.in)) {
            /* Exibindo Menu Inicial: */
            OpcaoMenu opcaoEscolhida = CONTINUE;
            log.warn(Menu.INICIAL);

            /* Enquanto a opção escolhida não for S (SAIR), solicitar entrada do usuário: */

            while(!opcaoEscolhida.equals(S)){

                opcaoEscolhida = valueOf(entrada.nextLine());
                switch (opcaoEscolhida){  //OBS: Usar ExecutorService + Future para aguardar a execução dos submenus
                    case A: // Gerenciar agências
                        log.warn("Menu Gerenciar agências escolhido!");
                        break;

                    case B: // Gerenciar clientes
                        log.warn("Menu Gerenciar clientes escolhido!");
                        break;

                    case C: // Gerenciar contas
                        log.warn("Menu Gerenciar contas escolhido!");
                        break;

                    case E: // Gerenciar emprestimos
                        log.warn("Menu Gerenciar empréstimos escolhido!");
                        break;

                    case S: // SAIR
                        log.warn("Tchau!");
                        break;
                        
                    default:
                        log.warn("Opção Inválida!");
                        break;
                }
            }
        }
    }




}