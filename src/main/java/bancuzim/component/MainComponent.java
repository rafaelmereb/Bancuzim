package bancuzim.component;

import bancuzim.view.ViewMenuPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
/**
 * Componente principal da aplicação, responsável por acionar a view principal
 */
public class MainComponent implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ViewMenuPrincipal viewMenuPrincipal= new ViewMenuPrincipal();
        viewMenuPrincipal.manterMenuPrincipal();
    }

}