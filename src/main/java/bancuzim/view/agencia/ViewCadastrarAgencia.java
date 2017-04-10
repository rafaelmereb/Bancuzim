package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * View correspondente ao Cadastro de uma Agência
 */

public class ViewCadastrarAgencia extends ViewAgencia{

    @Autowired
    private AgenciaService agenciaService;

    void load() throws FalhaCadastroException {
        manterCadastroDeAgencia();
    }

    /**
     * Mantém o cadastro de Agência
     */
    private void manterCadastroDeAgencia() throws FalhaCadastroException {
        exibirMenu();
        cadastrarAgencia(colherDadosDeAgencia());
    }

    /**
     * Exibe cabeçalho da View de Cadastro de Agência
     */
    private void exibirMenu() {
        System.out.println(Menu.CADASTRAR_AGENCIA);
    }




    /**
     * Confere a responsabilidade de salvar a agência à service correspondente
     *
     * @param agencia a ser persistida
     */
     private void cadastrarAgencia(Agencia agencia) throws FalhaCadastroException {
        agenciaService.salvarAgencia(agencia);
    }
}
