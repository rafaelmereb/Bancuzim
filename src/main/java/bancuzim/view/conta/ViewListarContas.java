package bancuzim.view.conta;

import bancuzim.entity.Conta;
import bancuzim.exception.listagem.FalhaListagemException;
import bancuzim.interfaces.ViewListarTodosInterface;
import bancuzim.util.Menu;

import java.util.ArrayList;

public class ViewListarContas  extends ViewGerenciarContas implements ViewListarTodosInterface{
    /**
     * "Carrega" a View responsável por listar todas as contas salvas
     */
    public void load(){
        manterViewListarContas();
    }

    /**
     * Mantém a View responsável por listar as agências salvas
     */
    private void manterViewListarContas() {
        exibirMenu(Menu.LISTAR_CONTAS);
        listarContas();
    }

    /**
     * Método responsável por listar as agências salvas
     */
    private void listarContas() {
        try {
            ArrayList<Conta> contas = contaService.listarContas();

            if (contas.size() > 0) {
                for (Conta conta : contas) {
                    exibirConta(conta);
                }
            }
        } catch (FalhaListagemException falha) {
            System.out.println(falha.getMessage());
        }
    }
}
