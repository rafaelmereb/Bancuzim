package bancuzim.exception;

public class FalhaCadastroException extends Throwable {

    public FalhaCadastroException(String entidade, String descricaoFalha) {
        super("\nFalha ao Cdastrar " + entidade + ": [" + descricaoFalha + "]");
    }
}
