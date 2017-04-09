package bancuzim.exception;

public class FalhaDelecaoException extends Throwable{

    public FalhaDelecaoException(String entidade, String descricaoFalha) {
        super("\nFalha ao cadastrar " + entidade + ": [" + descricaoFalha + "]");
    }

}
