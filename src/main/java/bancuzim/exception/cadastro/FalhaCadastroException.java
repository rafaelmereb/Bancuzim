package bancuzim.exception.cadastro;

import bancuzim.enums.Entidade;
import bancuzim.exception.FalhaCRUDException;

import static bancuzim.enums.Operacao.CADASTRAR;

public class FalhaCadastroException extends FalhaCRUDException {

    public FalhaCadastroException(Entidade entidade, String descricaoFalha) {
        super(CADASTRAR, entidade, descricaoFalha);
    }
}
