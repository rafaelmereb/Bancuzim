package bancuzim.view.conta;

import bancuzim.entity.Conta;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.interfaces.ViewAtualizarInterface;
import bancuzim.util.Menu;

import static bancuzim.enums.TipoConta.CORRENTE;

public class ViewAtualizarConta extends ViewGerenciarContas implements ViewAtualizarInterface {


    /**
     * "Carrega" a View responsável por atualizar contas
     */
    public void load() {
        exibirMenu(Menu.ATUALIZAR_CONTA);
        manterViewAtualizarConta();
    }

    /**
     * Mantém a View responsável por atualizar clientes
     */
    private void manterViewAtualizarConta() {
        try {
            try {
                atualizarDados(buscarConta(), colherDadosAtualizadosDeConta());
                System.out.println("Cliente atualizado com sucesso!");
            } catch (FalhaBuscaException e) {
                throw new FalhaAtualizacaoException(e.getEntidade(), e.getDescricaoFalha());
            }
        } catch (FalhaAtualizacaoException e) {
            System.out.println(e.getMessage());
        }

    }

    private Conta colherDadosAtualizadosDeConta() throws FalhaBuscaException {
        System.out.println("\n##### Digite os novos dados #####");
        return colherDadosDeConta();
    }

    /**
     * Atualiza os dados de uma conta a partir de novos dados coletados
     *
     * @param conta           a ser atualizada
     * @param contaAtualizada dados atualizados da conta
     * @throws FalhaAtualizacaoException caso alguma falha ocorra no processo
     */
    private void atualizarDados(Conta conta, Conta contaAtualizada) throws FalhaAtualizacaoException {
        if (conta != null) {
            //Setando os novos dados no registro já presente:
            conta.setAgencia(contaAtualizada.getAgencia());
            conta.setNumero(contaAtualizada.getNumero());
            conta.setCliente(contaAtualizada.getCliente());
            conta.setTipo_conta(contaAtualizada.getTipo_conta());
            if (contaAtualizada.getTipo_conta().equals(CORRENTE)) {
                //Caso seja uma conta corrente, ela tem um plano:
                conta.setPlano(contaAtualizada.getPlano());
            }
            conta.setSaldo(contaAtualizada.getSaldo());
            conta.setLimite(contaAtualizada.getLimite());

            //Atualizando conta:
            atualizarConta(conta);
        }
    }

    /**
     * Confere a responsabilidade de atualizar uma conta específica à service correspondente
     * @param conta com os dados atualizados
     * @throws FalhaAtualizacaoException caso alguma falha ocorra no processo
     */
    private void atualizarConta(Conta conta) throws FalhaAtualizacaoException {
        contaService.atualizarConta(conta);
    }
}

