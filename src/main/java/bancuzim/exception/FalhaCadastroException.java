package bancuzim.exception;

import bancuzim.view.agencia.ViewCadastrarAgencia;
import org.apache.log4j.Logger;

public class FalhaCadastroException extends Throwable {

    Logger log = Logger.getLogger(ViewCadastrarAgencia.class);

    public FalhaCadastroException(String mensagem, Exception exception) {
        log.error(mensagem, exception);
    }
}
