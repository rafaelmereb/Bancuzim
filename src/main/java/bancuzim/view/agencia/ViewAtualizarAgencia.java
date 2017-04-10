package bancuzim.view.agencia;

import bancuzim.abstracts.ViewAgencia;
import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaAtualizacaoException;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;

import java.util.Scanner;

public class ViewAtualizarAgencia extends ViewAgencia {

    void load() {
        exibirMenu(Menu.ATUALIZAR_AGENCIA);
        manterViewAtualizarAgencia();
    }

    /**
     * Mantém a View responsável por atualizar agências
     */
    private void manterViewAtualizarAgencia() {
        //Buscando agência a ser atualizada:
        Agencia agenciaEncontrada = buscarAgencia();

        //Atualizando agência encontrada:
        if (agenciaEncontrada != null) {
            try {
                atualizarAgencia(colherDadosDeAgencia());
            } catch (FalhaAtualizacaoException e) {
                e.getMessage();
            }
        }
    }

    /**
     * Confere a responsabilidade de atualizar uma agência específica à service correspondente
     *
     * @param agencia com os dados atualizados
     * @throws FalhaAtualizacaoException
     */
    private void atualizarAgencia(Agencia agencia) throws FalhaAtualizacaoException {
        agenciaService.atualizarAgencia(agencia);
    }
}
