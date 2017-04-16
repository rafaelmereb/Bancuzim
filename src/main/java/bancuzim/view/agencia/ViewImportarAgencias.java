package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.cadastro.FalhaCadastroException;
import bancuzim.exception.importacao.FalhaImportacaoException;
import bancuzim.interfaces.ViewImportarInterface;
import bancuzim.util.Menu;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bancuzim.enums.Entidade.AGENCIA;
import static bancuzim.util.Leitura.lerCampoStringObrigatorio;

public class ViewImportarAgencias extends ViewGerenciarAgencias implements ViewImportarInterface{

    /**
     * "Carrega a View responsável por Importar Agências"
     */
    public void load() {
        exibirMenu(Menu.IMPORTAR_AGENCIA);
        manterViewImportarAgencia();
    }

    /**
     * Mantém a View responsável por Importar Agências
     */
    private void manterViewImportarAgencia() {
        importarAgencias(consumirArquivo(colherCaminhoDoArquivo()));
    }

    /**
     * Método responsável por salvar as agências que foram extraídas de um arquivo
     * @param agencias lista de agências a serem importadas
     */
    private void importarAgencias(ArrayList<Agencia> agencias) {
        for (Agencia agencia: agencias) {
            try {
                agenciaService.salvarAgencia(agencia);
            } catch (FalhaCadastroException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Agências importadas com sucesso!");
    }

    /**
     * Interpreta o arquivo a ser importado pela aplicação
     * TODO: IMPLEMENTAR MULTITHREAD NO CONSUMO DO ARQUIVO
     * @param caminhoDoArquivo a ser interpretado
     * @return uma lista de agências com as informações do arquivo
     */
    private ArrayList<Agencia> consumirArquivo(Path caminhoDoArquivo) {
        ArrayList<Agencia> listaAgencias = null;
        try {
            //Colhe linhas do arquivo:
            List<String> linhasDoArquivo = colherLinhasDoArquivo(caminhoDoArquivo);
            if (linhasDoArquivo != null) {
                for (String linha : linhasDoArquivo) {
                    //Colhe atributos de agência presentes na linha:
                    String[] atributosDeAgenda = StringUtils.split(linha, ";");
                    //Adiciona agência obtida do arquivo na lista de agências a serem retornadas:
                    listaAgencias.add(montarAgencia(atributosDeAgenda));
                }
            }
        } catch (FalhaImportacaoException | IOException e) {
            System.out.println(e.getMessage());
        }
        return listaAgencias;
    }

    /**
     * Verifica se um caminho de arquivo é acessível (existe e é passível de leitura)
     * @param caminho a ser verificado
     * @return se o arquivo é válido(true) ou inválido (false)
     * @throws FalhaImportacaoException se uma falha ocorrer no processo
     */
    private boolean isAcessivel(Path caminho) throws FalhaImportacaoException {
        return Files.isReadable(caminho);
    }

    /**
     * Monta um objeto agência a partir de uma String de atributos
     *
     * @param atributosDeAgenda a serem colhidos
     * @return uma agência com os atributos informados
     * @throws FalhaImportacaoException caso aconteça alguma falha no processo
     */
    private Agencia montarAgencia(String[] atributosDeAgenda) throws FalhaImportacaoException {
        Agencia agencia = new Agencia();
        //Divide a linha em array de Strings a partir do caractere ";".
        if (atributosDeAgenda.length != 6) {
            //Colhe os atributos e os seta num objeto agência

            agencia.setId(Integer.valueOf(atributosDeAgenda[0])); // Id
            agencia.setNome(atributosDeAgenda[1]); // Nome
            agencia.setCodigo(Integer.valueOf(atributosDeAgenda[2])); // Código
            agencia.setEndereco(atributosDeAgenda[3]); // Endereço
            agencia.setGerente(atributosDeAgenda[4]); // Gerente
            return agencia;
        } else {
            throw new FalhaImportacaoException(AGENCIA, "Falha ao colher atributos de agenda!");
        }
    }

    /**
     * Colhe do usuário o caminho do arquivo a ser importado
     *
     * @return o caminho (Path) do arquivo a ser importado
     */
    private Path colherCaminhoDoArquivo() {
        return Paths.get(lerCampoStringObrigatorio("Entre com o caminho (completo) do arquivo a ser importado:"));

    }

    /**
     * Colhe as linhas de um arquivo a partir de seu caminho
     *
     * @param caminhoDoArquivo a ser processado
     * @return lista de Strings cujas Strings são as linhas do arquivo
     * @throws FalhaImportacaoException se não é possível ler o arquivo
     * @throws IOException              se um erro I/O ocorrer ao ler o arquivo ou uma sequência de bytes for mal-formada ou inmapeável é lida.
     */
    private List<String> colherLinhasDoArquivo(Path caminhoDoArquivo) throws FalhaImportacaoException, IOException {
        if (isAcessivel(caminhoDoArquivo)) {
            return Collections.synchronizedList(Files.readAllLines(caminhoDoArquivo));
        } else return null;
    }

}
