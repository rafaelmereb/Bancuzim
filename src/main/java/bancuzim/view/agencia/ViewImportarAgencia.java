package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.exception.FalhaImportacaoException;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ViewImportarAgencia {

    public void load() {
        exibirMenu(Menu.IMPORTAR_AGENCIA);
        manterViewImportarAgencia();
    }

    private void manterViewImportarAgencia() {
        try {
            interpretarArquivo(colherCaminhoDoArquivo());
        } catch (FalhaImportacaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void interpretarArquivo(Path caminhoDoArquivo) throws FalhaImportacaoException, IOException {
        if (Files.exists(caminhoDoArquivo)) {
            if (Files.isReadable(caminhoDoArquivo)) {
                ArrayList<String> linhasDoArquivo = (ArrayList<String>) colherLinhasDoArquivo(caminhoDoArquivo);
                try {
                    for (String linha : linhasDoArquivo) {

                        String[] atributosDeAgenda = StringUtils.split(linha, ";");
                        //Divide a linha em array de Strings a partir do caractere ";".
                        if (atributosDeAgenda.length != 6) {
                            Agencia agencia = new Agencia();
                            agencia.setId(Integer.valueOf(atributosDeAgenda[0])); // Id
                            agencia.setNome(atributosDeAgenda[1]);
                            agencia.setCodigo(Integer.valueOf(atributosDeAgenda[2]));
                            agencia.setEndereco(atributosDeAgenda[3]);
                            agencia.setGerente(atributosDeAgenda[4]);
                        } else throw new FalhaImportacaoException(Agencia.class.getSimpleName(), "Arquivo não segue o padrão esperado!");
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            } else throw new FalhaImportacaoException(Agencia.class.getSimpleName() , "Não é possível ler o arquivo");
        } else throw new FileNotFoundException("Arquivo não encontrado no caminho informado!");
    }

    private Path colherCaminhoDoArquivo() {
        return Paths.get(Leitura.lerCampoStringObrigatorio("Entre com o caminho (completo) do arquivo a ser importado:"));

    }

    private List<String> colherLinhasDoArquivo(Path caminhoDoArquivo) throws IOException {
        return Files.readAllLines(caminhoDoArquivo);
    }

    private void exibirMenu(String menu) {
        System.out.println(menu);
    }
}
