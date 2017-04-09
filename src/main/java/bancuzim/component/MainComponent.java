package bancuzim.component;

import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.exception.FalhaDelecaoException;
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
    public void run(String... args) throws Exception {
        try {
            viewMenuPrincipal.load();
        } catch (FalhaCadastroException | FalhaDelecaoException | FalhaBuscaException ignored) {

        }
    }
}