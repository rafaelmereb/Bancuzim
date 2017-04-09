package bancuzim.view.agencia;

import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.*;

public class ViewBuscarAgencia {

    @Autowired
    private AgenciaService agenciaService;

    void load() throws FalhaBuscaException {
        exibirMenu();
        Scanner leitor = new Scanner(System.in);
        exibirAgencia(
                buscarAgenciaSegundoReferencia(
                        colherReferenciaParaBusca(leitor), leitor)
        );
    }

    /**
     * Exibe a agência buscada, caso a mesma tenha sido encontrada
     *
     * @param agencia a ser exibida
     */
    private void exibirAgencia(Agencia agencia) {
        if (agencia != null) {
            System.out.println("\n" + agencia.toString());
        }
    }

    /**
     * Interpreta a opcao escolhida a fim de redirecionar a busca segundo a referência correspondente
     *
     * @param opcao  correspondente a escolha da referência utilizada para a consulta
     * @param leitor que será utilizada para receber a entrada do usuário
     * @return agencia encontrada, caso a mesma exista
     * @throws FalhaBuscaException caso alguma falha ocorra no processo
     */
    Agencia buscarAgenciaSegundoReferencia(OpcaoMenu opcao, Scanner leitor) throws FalhaBuscaException {

        if (isA(opcao)) { // Parâmetro de busca: Código
            return buscarAgenciaPorCodigo(colherCodigoAgencia(leitor));
        } else { // Parâmetro de busca: Nome
            return buscarAgenciaPorNome(colherNomeAgencia(leitor));
        }

    }

    /**
     * Colhe o código da agência pretendida
     *
     * @param leitor para receber a entrada do usuário
     * @return código da agência pretendida
     */
    Integer colherCodigoAgencia(Scanner leitor) {
        return Leitura.lerCampoIntegerObrigatorio("Código da agência: ", leitor);
    }

    /**
     * Colhe o nome da agência pretendida
     *
     * @param leitor que receberá a entrada do usuário
     * @return nome da agência pretendida
     */
    String colherNomeAgencia(Scanner leitor) {
        return Leitura.lerCampoStringObrigatorio("Nome da agência: ", leitor);
    }

    /**
     * Exibe cabeçalho da View de Busca de Agência
     */
    private void exibirMenu() {
        System.out.println(Menu.BUSCAR_AGENCIA);
    }

    /**
     * Colhe a referência que será utilizada na busca da agência (nome ou código )
     *
     * @param leitor que receberá a entrada do usuário
     * @return referência que será utilizada na busca da agência (nome ou código)
     */
    OpcaoMenu colherReferenciaParaBusca(Scanner leitor) {

        OpcaoMenu opcao = CONTINUE;
        ArrayList<OpcaoMenu> opcoesDisponiveis = new ArrayList<>();
        opcoesDisponiveis.add(A);
        opcoesDisponiveis.add(B);

        while (!opcoesDisponiveis.contains(opcao)) {
            System.out.println("Escolha a opção desejada:\nA - Buscar agência pelo seu Código\nB - Buscar agência pelo seu Nome");
            opcao = Leitura.lerOpcaoMenu("Opção: ", leitor);
            switch (opcao) {
                case A:
                case B:
                    return opcao;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        return opcao;
    }

    /**
     * Realiza a busca da agência pretendida segundo nome fornecido
     *
     * @param nomeAgencia utilizada como referência na busca
     * @return agencia com o nome informado, caso a mesma exista
     * @throws FalhaBuscaException caso alguma falha ocorra no processo
     */
    Agencia buscarAgenciaPorNome(String nomeAgencia) throws FalhaBuscaException {
        return agenciaService.buscarAgenciaPorNome(nomeAgencia);
    }

    /**
     * Realiza a busca da agência pretendida segundo código fornecido
     *
     * @param codigoAgencia utilizado como referência na busca
     * @return agencia com o código informado, caso a mesma exista
     * @throws FalhaBuscaException caso alguma falha ocorra no processo
     */
    Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) throws FalhaBuscaException {
        return agenciaService.buscarAgenciaPorCodigo(codigoAgencia);
    }

}
