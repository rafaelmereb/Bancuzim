package bancuzim.exception;

public class FalhaBuscaException extends Exception {

    public FalhaBuscaException(String entidade, String descricaoFalha) {
        super("\nFalha ao Buscar " + entidade + ": [" + descricaoFalha + "]");
    }

}
