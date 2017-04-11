package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

public class ViewBuscarAgencia extends ViewAgencia {

    @Autowired
    private AgenciaService agenciaService;

    /**
     * "Carrega" a View responsável por buscar agências
     */
    void load(){
        exibirMenu(Menu.BUSCAR_AGENCIA);
        manterViewBuscarAgencia();
    }

    /**
     * Mantém a View responsável por buscar agências
     */
    private void manterViewBuscarAgencia() {
        exibirAgencia(buscarAgencia());
    }

}
