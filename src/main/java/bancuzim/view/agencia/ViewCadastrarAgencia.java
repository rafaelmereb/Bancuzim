package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.interfaces.ViewCadastrarInterface;
import bancuzim.util.Menu;

/**
 * View correspondente ao Cadastro de uma Agência
 */
public class ViewCadastrarAgencia extends ViewGerenciarAgencias implements ViewCadastrarInterface{

    /**
     * "Carrega" a View responsável por cadastrar agências
     */
    public void load() {
        exibirMenu(Menu.CADASTRAR_AGENCIA);
        manterViewCadastrarAgencia();
    }

    /**
     * Mantém a View responsável por cadastrar agências
     */
    private void manterViewCadastrarAgencia() {
        cadastrarAgencia(colherDadosDeAgencia());
    }

    /**
     * Confere a responsabilidade de salvar a agência à service correspondente
     *
     * @param agencia a ser persistida
     */
    private void cadastrarAgencia(Agencia agencia) {
        try {
            agenciaService.salvarAgencia(agencia);
        } catch (FalhaCadastroException e) {
            System.out.println(e.getMessage());
        }
    }
}
