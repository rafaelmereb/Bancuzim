package bancuzim.exception.listagem;

import bancuzim.enums.Entidade;
import bancuzim.exception.FalhaCRUDException;

import static bancuzim.enums.Operacao.LISTAR_TODOS;

public class FalhaListagemException extends FalhaCRUDException{

    public FalhaListagemException(Entidade entidade, String descricaoFalha) {
        super(LISTAR_TODOS, entidade, descricaoFalha);
    }
}
