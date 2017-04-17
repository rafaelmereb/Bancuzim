package bancuzim.view.conta;

import bancuzim.entity.Conta;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Menu;

public class ViewCadastrarConta extends ViewGerenciarContas implements ViewCadastrarInterface {

    public void load() {
        exibirMenu(Menu.CADASTRAR_CONTA);
        manterViewCadastrarContas();
    }

    /**
     * Mantém a view responsável por cadastrar Contas
     */
    private void manterViewCadastrarContas() {
        try {
            cadastrarConta(colherDadosDeConta());

        } catch (FalhaCadastroException falha) {
            System.out.println(falha.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de salvar uma conta à service correspondente
     *
     * @param conta a ser persistida
     */
    private void cadastrarConta(Conta conta) throws FalhaCadastroException {
        contaService.salvarConta(conta);
    }


}
