package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaListagemException;
import bancuzim.util.Menu;

import java.util.ArrayList;

public class ViewListarAgencias extends ViewAgencia {

    public void load() throws FalhaListagemException {
        manterViewListarAgencias();
    }

    private void manterViewListarAgencias() throws FalhaListagemException {
        exibirMenu(Menu.LISTAR_AGENCIAS);
        listarAgencias();
    }

    private void listarAgencias() throws FalhaListagemException {

        for (Agencia agencia : agenciaService.listarAgencias()) {
            exibirAgencia(agencia);
        }

    }
}
