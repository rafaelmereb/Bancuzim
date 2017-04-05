package theBancuzim.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import theBancuzim.entity.Agencia;
import theBancuzim.enums.OpcaoMenu;
import theBancuzim.repository.AgenciaRepository;
import theBancuzim.util.Menus;

import java.util.Scanner;

public class AgenciaController implements CommandLineRunner {

    @Autowired
    private AgenciaRepository agenciaRepository;

    private Logger log;
    Scanner entrada;
    OpcaoMenu opcaoMenu;

    public AgenciaController() {
        log = Logger.getLogger(AgenciaController.class);
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
