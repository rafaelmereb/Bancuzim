package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaAtualizacaoException;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;

import java.util.Scanner;

public class ViewAtualizarAgencia extends ViewAgencia {

    private final String AGENCIA = Agencia.class.getSimpleName();

    void load() throws FalhaBuscaException, FalhaAtualizacaoException {
        exibirMenu();
        Agencia agenciaEncontrada = buscarAgencia();

        if (agenciaEncontrada != null) {
            atualizarAgencia(colherDadosAtualizados());
        }
    }

    /**
     * Colhe dados da agência atualizados
     *
     * @return agencia cujos dados foram atualizados
     */
    private Agencia colherDadosAtualizados() {

        Scanner leitor = new Scanner(System.in);
        Agencia agencia = new Agencia();
        agencia.setNome(Leitura.lerCampoStringObrigatorio("Nome da Agência: ", leitor));
        agencia.setGerente(Leitura.lerCampoStringObrigatorio("Nome do Gerente da Agência: ", leitor));
        agencia.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço da Agência: ", leitor));
        return agencia;

    }


    private void atualizarAgencia(Agencia agencia) throws FalhaAtualizacaoException {
        agenciaService.atualizarAgencia(agencia);
    }

    private void exibirMenu() {
        System.out.println(Menu.ATUALIZAR_AGENCIA);
    }
}
