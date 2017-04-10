package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.exception.FalhaDelecaoException;
import bancuzim.util.Menu;

import java.util.Scanner;

public class ViewDeletarAgencia extends ViewAgencia{

    private final String AGENCIA = Agencia.class.getSimpleName();

    void load() throws FalhaBuscaException, FalhaDelecaoException {
        exibirMenu();
        deletarAgencia();
    }

    private void exibirMenu() {
        System.out.println(Menu.DELETAR_AGENCIA);
    }

    private void deletarAgencia() throws FalhaDelecaoException{
        Scanner leitor = new Scanner(System.in);
        deletarAgenciaSegundoReferencia(colherReferenciaParaBusca(leitor), leitor);

    }

    private void deletarAgenciaSegundoReferencia(OpcaoMenu opcaoMenu, Scanner leitor) {
        switch (opcaoMenu){
            case A:
                deletarAgenciaPorNome(colherNomeAgencia(leitor));
                break;
            case B:
                deletarAgenciaPorCodigo(colherCodigoAgencia(leitor));
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void deletarAgenciaPorCodigo(Integer codigo) {
        agenciaService.deletarAgenciaPorCodigo(codigo);
    }

    private void deletarAgenciaPorNome(String nome) {
        agenciaService.deletarAgenciaPorNome(nome);
    }


}
