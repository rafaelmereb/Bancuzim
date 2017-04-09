package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class ViewAtualizarAgencia {

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private ViewBuscarAgencia viewBuscarAgencia;

    @Autowired
    private ViewCadastrarAgencia viewCadastrarAgencia;

    private final String AGENCIA = Agencia.class.getSimpleName();

    void load() throws FalhaBuscaException, FalhaCadastroException {
        exibirMenu();
        Scanner leitor = new Scanner(System.in);
        Agencia agenciaBuscada = viewBuscarAgencia.buscarAgenciaSegundoReferencia(
                viewBuscarAgencia.colherReferenciaParaBusca(leitor), leitor);

        if (agenciaBuscada != null){
            viewCadastrarAgencia.cadastrarAgencia(viewCadastrarAgencia.colherDadosDeAgencia());
        }
    }

    private void atualizarAgencia(Agencia agencia) throws FalhaCadastroException {
        viewCadastrarAgencia.cadastrarAgencia(agencia);
    }

    private void exibirMenu() {
        System.out.println(Menu.ATUALIZAR_AGENCIA);
    }
}
