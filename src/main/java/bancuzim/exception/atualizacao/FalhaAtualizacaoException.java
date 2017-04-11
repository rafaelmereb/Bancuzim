package bancuzim.exception.atualizacao;

public class FalhaAtualizacaoException extends Exception {

    public FalhaAtualizacaoException(String entidade, String descricaoFalha) {
        super("\nFalha ao Atualizar " + entidade + ": [" + descricaoFalha + "]");
    }
}
