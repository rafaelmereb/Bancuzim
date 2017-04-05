package bancuzim.service;

import bancuzim.enums.OpcaoMenu;
import bancuzim.repository.AgenciaRepository;
import bancuzim.util.Menus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class AgenciaService implements CommandLineRunner {

    @Autowired
    private AgenciaRepository agenciaRepository;

    private Logger log;
    Scanner entrada;
    OpcaoMenu opcaoMenu;

    public AgenciaService() {
        log = Logger.getLogger(AgenciaService.class);
        entrada = new Scanner(System.in);
        opcaoMenu = OpcaoMenu.CONTINUE;
    }

    @Override
    public void run(String... args) throws Exception {

        try {

        }catch(Exception e){

        }





    }

    private void gerenciarAgencias(){

        while (opcaoMenu != OpcaoMenu.V){
            log.warn(Menus.GERENCIAR_AGENCIAS);
        }
    }
}
