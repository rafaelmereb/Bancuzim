package bancuzim.exception.busca;

public class FalhaBuscaException extends Exception {

    public FalhaBuscaException(String entidade, String descricaoFalha) {
        super("\nFalha ao Buscar " + entidade + ": [" + descricaoFalha + "]");
    }

}
