package bancuzim.exception.busca;

import bancuzim.enums.Entidade;
import bancuzim.exception.FalhaCRUDException;

import static bancuzim.enums.Operacao.BUSCAR;

public class FalhaBuscaException extends FalhaCRUDException {

    public FalhaBuscaException(Entidade entidade, String descricaoFalha) {
        super(BUSCAR, entidade, descricaoFalha);
    }
}
