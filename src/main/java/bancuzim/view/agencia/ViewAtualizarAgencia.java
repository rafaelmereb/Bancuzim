package bancuzim.view.agencia;


import bancuzim.entity.Agencia;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewAtualizarInterface;
import bancuzim.util.Menu;

public class ViewAtualizarAgencia extends ViewGerenciarAgencias implements ViewAtualizarInterface {

    /**
     * "Carrega" a View responsável por atualizar agências
     */
    public void load() {
        exibirMenu(Menu.ATUALIZAR_AGENCIA);
        manterViewAtualizarAgencia();
    }

    /**
     * Mantém a View responsável por atualizar agências
     */
    private void manterViewAtualizarAgencia() {
        try {
            try {
                atualizarDados(buscarAgencia());
                System.out.println("Agência atualizada com sucesso!");
            } catch (FalhaBuscaException falha) {
                throw new FalhaAtualizacaoException(falha.getEntidade(), falha.getDescricaoFalha());
            }
        } catch (FalhaAtualizacaoException falha) {
            System.out.println(falha.getMessage());
        }

    }

    private void atualizarDados(Agencia agencia) throws FalhaAtualizacaoException {
        if (agencia != null) {
            //Colhendo os dados atualizados:
            System.out.println("\n##### Digite os novos dados #####");
            Agencia agenciaAtualizada = colherDadosDeAgencia();

            //Setando os novos dados no registro já presente:
            agencia.setCodigo(agenciaAtualizada.getCodigo());
            agencia.setNome(agenciaAtualizada.getNome());
            agencia.setGerente(agenciaAtualizada.getGerente());
            agencia.setEndereco(agenciaAtualizada.getEndereco());

            //Atualizando agência:
            atualizarAgencia(agencia);
        }
    }

    /**
     * Confere a responsabilidade de atualizar uma agência específica à service correspondente
     *
     * @param agencia com os dados atualizados
     * @throws FalhaAtualizacaoException caso uma falha ocorra no processo
     */
    private void atualizarAgencia(Agencia agencia) throws FalhaAtualizacaoException {
        agenciaService.atualizarAgencia(agencia);
    }
}
