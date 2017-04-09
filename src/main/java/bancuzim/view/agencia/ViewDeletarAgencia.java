package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaDelecaoException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class ViewDeletarAgencia {

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private ViewBuscarAgencia viewBuscarAgencia;

    private final String AGENCIA = Agencia.class.getSimpleName();

    void load() throws FalhaBuscaException, FalhaDelecaoException {
        exibirMenu();
        Scanner leitor = new Scanner(System.in);
        Agencia agenciaBuscada = viewBuscarAgencia.buscarAgenciaSegundoReferencia(
                viewBuscarAgencia.colherReferenciaParaBusca(leitor), leitor);

        if (agenciaBuscada != null){
            deletarAgencia(agenciaBuscada);
        }
    }

    private void deletarAgencia(Agencia agencia) throws FalhaDelecaoException{
        agenciaService.deletarAgencia(agencia);
    }

    private void exibirMenu() {
        System.out.println(Menu.DELETAR_AGENCIA);
    }
}
