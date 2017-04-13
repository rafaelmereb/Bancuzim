package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.interfaces.ViewListarTodosInterface;
import bancuzim.util.Menu;

import java.util.ArrayList;

public class ViewListarAgencias extends ViewGerenciarAgencias implements ViewListarTodosInterface{

    /**
     * "Carrega" a View responsável por listar todas as agências salvas
     */
    public void load(){
        manterViewListarAgencias();
    }

    /**
     * Mantém a View responsável por listar as agências salvas
     */
    private void manterViewListarAgencias() {
        exibirMenu(Menu.LISTAR_AGENCIAS);
        listarAgencias();
    }

    /**
     * Método responsável por listar as agências salvas
     */
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
