package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class ViewBuscarAgencia extends ViewAgencia {

    @Autowired
    private AgenciaService agenciaService;

    void load() throws FalhaBuscaException {
        exibirMenu(Menu.BUSCAR_AGENCIA);
        manterViewBuscarAgencia();
    }

    private void manterViewBuscarAgencia() {
        exibirAgencia(buscarAgencia());
    }

}
