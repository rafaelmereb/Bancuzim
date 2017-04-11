package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.util.Menu;

import java.util.ArrayList;

public class ViewListarAgencias extends ViewAgencia {

    public void load(){
        manterViewListarAgencias();
    }

    private void manterViewListarAgencias() {
        exibirMenu(Menu.LISTAR_AGENCIAS);
        listarAgencias();
    }

    private void listarAgencias() {
        try {
            ArrayList<Agencia> agencias = agenciaService.listarAgencias();

            if (agencias.size() > 0) {
                for (Agencia agencia : agencias) {
                    exibirAgencia(agencia);
                }
            }
        } catch (FalhaListagemException e) {
            System.out.println(e.getMessage());
        }
    }
}
