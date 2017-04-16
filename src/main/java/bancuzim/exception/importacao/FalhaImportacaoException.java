package bancuzim.exception.importacao;

import bancuzim.enums.Entidade;
import bancuzim.exception.FalhaCRUDException;

import static bancuzim.enums.Operacao.IMPORTAR;

public class FalhaImportacaoException extends FalhaCRUDException{

    public FalhaImportacaoException(Entidade entidade, String descricaoFalha) {
        super(IMPORTAR, entidade, descricaoFalha);
    }
}
