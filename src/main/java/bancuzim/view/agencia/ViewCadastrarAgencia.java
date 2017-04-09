package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaCadastroException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * View correspondente ao Cadastro de uma Agência
 */

public class ViewCadastrarAgencia {

    @Autowired
    private AgenciaService agenciaService;

    void load() throws FalhaCadastroException {
        manterCadastroDeAgencia();
    }

    /**
     * Mantém o cadastro de Agência
     */
    private void manterCadastroDeAgencia() throws FalhaCadastroException {
        exibirMenu();
        cadastrarAgencia(colherDadosDeAgencia());
    }

    /**
     * Exibe cabeçalho da View de Cadastro de Agência
     */
    private void exibirMenu() {
        System.out.println(Menu.CADASTRAR_AGENCIA);
    }

    /**
     * Colhe dados da agência a ser cadastrada
     *
     * @return agencia cujos dados foram colhidos
     */
    Agencia colherDadosDeAgencia() {
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
     void cadastrarAgencia(Agencia agencia) throws FalhaCadastroException {
        agenciaService.salvarAgencia(agencia);
    }
}
