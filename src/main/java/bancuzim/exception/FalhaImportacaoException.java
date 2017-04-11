package bancuzim.exception;

public class FalhaImportacaoException extends Exception{

    public FalhaImportacaoException(String entidade, String descricaoFalha) {
        super("\nFalha ao Importar objetos do tipo " + entidade + ": [" + descricaoFalha + "]");
    }
}
