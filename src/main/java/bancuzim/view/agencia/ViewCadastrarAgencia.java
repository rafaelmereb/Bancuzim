package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

/**
 * View correspondente ao Cadastro de uma Agência
 */

public class ViewCadastrarAgencia implements CommandLineRunner {

    @Autowired
    AgenciaService agenciaService;

    private Logger log = Logger.getLogger(ViewCadastrarAgencia.class);

    @Override
    public void run(String... args) {
        try {
            manterCadastroDeAgencia();
        } catch (FalhaCadastroException e) {
           //
        }
    }

    /**
     * Mantém o cadastro de Agência
     */
    private void manterCadastroDeAgencia() throws FalhaCadastroException {
        exibirMenu();
        cadastrarAgencia(colherAgencia());
    }

    /**
     * Exibe cabeçalho da View de Cadastro de Agência
     */
    private void exibirMenu() {
        log.warn(Menu.CADASTRAR_AGENCIA);
    }

    /**
     * Colhe dados da agência a ser cadastrada
     *
     * @return agencia cujos dados foram colhidos
     */
    private Agencia colherAgencia() {
        Scanner leitor = new Scanner(System.in);
        Agencia agencia = new Agencia();

        agencia.setCodigo(Leitura.lerCampoIntegerObrigatorio("Código da Agência: ", leitor));
        agencia.setNome(Leitura.lerCampoStringObrigatorio("Nome da Agência: ", leitor));
        agencia.setGerente(Leitura.lerCampoStringObrigatorio("Nome do Gerente da Agência: ", leitor));
        agencia.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço da Agência: ", leitor));

        return agencia;
    }


    /**
     * Confere a responsabilidade de salvar a agência à service correspondente
     *
     * @param agencia a ser persistida
     */
    private void cadastrarAgencia(Agencia agencia) throws FalhaCadastroException {
        agenciaService.salvarAgencia(agencia);
    }
}
