package bancuzim.view.conta;

import bancuzim.entity.Conta;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Menu;

public class ViewCadastrarConta extends ViewGerenciarContas implements ViewCadastrarInterface{

    public void load() {
        exibirMenu(Menu.CADASTRAR_CONTA);
        manterViewCadastrarCliente();
    }

    private void manterViewCadastrarCliente() {
        cadastrarConta(colherDadosDeConta());
    }

    /**
     * Confere a responsabilidade de salvar uma conta à service correspondente
     *
     * @param conta a ser persistida
     */
    private void cadastrarConta(Conta conta) {
        /* try {
            contaService.salvarConta(conta);
        } catch (FalhaCadastroException e) {
            System.out.println(e.getMessage());
        }
        */
    }


}
