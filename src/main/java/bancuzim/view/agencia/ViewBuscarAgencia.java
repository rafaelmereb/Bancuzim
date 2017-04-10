package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class ViewBuscarAgencia extends ViewAgencia {

    @Autowired
    private AgenciaService agenciaService;

    void load() throws FalhaBuscaException {
        exibirMenu();
        Scanner leitor = new Scanner(System.in);
        exibirAgencia(
                buscarAgenciaPorReferencia(
                        colherReferenciaParaBusca(leitor), leitor)
        );
    }

    /**
     * Exibe cabeçalho da View de Busca de Agência
     */
    private void exibirMenu() {
        System.out.println(Menu.BUSCAR_AGENCIA);
    }

}
