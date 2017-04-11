package bancuzim.component;

import bancuzim.exception.*;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Componente principal da aplicação, responsável por acionar a view principal
 */

@Component
public class MainComponent implements CommandLineRunner {

    @Autowired
    private ViewMenuPrincipal viewMenuPrincipal;

    @Override
    /**
     * Aciona a View correspondente ao Menu Principal
     */
    public void run(String... args) throws Exception {
        viewMenuPrincipal.load();
    }
}