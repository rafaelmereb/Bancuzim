package bancuzim.exception;

public class FalhaAtualizacaoException extends Throwable {

    public FalhaAtualizacaoException(String entidade, String descricaoFalha) {
        super("\nFalha ao Atualizar " + entidade + ": [" + descricaoFalha + "]");
    }
}
