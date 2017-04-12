package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * View correspondente ao Cadastro de uma Agência
 * TODO: Verificar se já não há agência já cadastrada com código/nome equivalentes antes de salvar o objeto
 */

public class ViewCadastrarAgencia extends ViewAgencia {

    @Autowired
    private AgenciaService agenciaService;

    void load() {
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
