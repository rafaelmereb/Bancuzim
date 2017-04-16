package bancuzim.exception.delecao;

import bancuzim.enums.Entidade;
import bancuzim.exception.FalhaCRUDException;

import static bancuzim.enums.Operacao.DELETAR;

public class FalhaDelecaoException extends FalhaCRUDException{

    public FalhaDelecaoException(Entidade entidade, String descricaoFalha) {
        super(DELETAR, entidade, descricaoFalha);

    }

}
