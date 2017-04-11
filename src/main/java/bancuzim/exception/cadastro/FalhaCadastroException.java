package bancuzim.exception.cadastro;

public class FalhaCadastroException extends Exception {

    public FalhaCadastroException(String entidade, String descricaoFalha) {
        super("\nFalha ao Cadastrar " + entidade + ": [" + descricaoFalha + "]");
    }
}
