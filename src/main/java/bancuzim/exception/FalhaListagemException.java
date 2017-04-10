package bancuzim.exception;

public class FalhaListagemException extends Exception {

    public FalhaListagemException(String entidade, String descricaoFalha) {
        super("\nFalha ao Listar todos os objetos do tipo " + entidade + " cadastrados: [" + descricaoFalha + "]");
    }

}
