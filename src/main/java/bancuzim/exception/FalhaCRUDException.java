package bancuzim.exception;

import bancuzim.enums.Operacao;
import bancuzim.enums.Entidade;

public class FalhaCRUDException extends Exception {
    private final Operacao operacao;
    private final Entidade entidade;
    private final String descricaoFalha;

    public FalhaCRUDException(Operacao operacao, Entidade entidade, String descricaoFalha){
        super("Falha ao realizar operação " + operacao.name() + " sobre a entidade " + entidade.name() + " [" + descricaoFalha + "]");
        this.entidade = entidade;
        this.descricaoFalha = descricaoFalha;
        this.operacao = operacao;

    }

    public Operacao getOperacao() {
        return operacao;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public String getDescricaoFalha() {
        return descricaoFalha;
    }

}
