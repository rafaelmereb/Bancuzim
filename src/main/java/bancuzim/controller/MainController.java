package theBancuzim.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import theBancuzim.util.Menus;

import java.util.Scanner;

@Component
public class MainController implements CommandLineRunner {

    private Logger log = Logger.getLogger(MainController.class);

    @Override
    public void run(String... args) throws Exception {

        try (Scanner scanner = new Scanner(System.in)) {

            log.warn(Menus.INICIAL);
        }

    }
}