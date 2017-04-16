package bancuzim.exception.atualizacao;

import bancuzim.enums.Entidade;
import bancuzim.exception.FalhaCRUDException;

import static bancuzim.enums.Operacao.ATUALIZAR;

public class FalhaAtualizacaoException extends FalhaCRUDException {

    public FalhaAtualizacaoException(Entidade entidade, String descricaoFalha) {
        super(ATUALIZAR, entidade, descricaoFalha);
    }
}
