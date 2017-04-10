package bancuzim.abstracts;

import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.*;

public abstract class ViewAgencia {

    @Autowired
    public AgenciaService agenciaService;

    public final String AGENCIA = Agencia.class.getSimpleName();

    /**
     * Colhe dados da agência a ser cadastrada
     *
     * @return agencia cujos dados foram colhidos
     */
    public Agencia colherDadosDeAgencia() {
        Scanner leitor = new Scanner(System.in);
        Agencia agencia = new Agencia();

        agencia.setCodigo(Leitura.lerCampoIntegerObrigatorio("Código da Agência: "));
        agencia.setNome(Leitura.lerCampoStringObrigatorio("Nome da Agência: "));
        agencia.setGerente(Leitura.lerCampoStringObrigatorio("Nome do Gerente da Agência: "));
        agencia.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço da Agência: "));

        return agencia;
    }

    /**
     * Método responsável por buscar uma agência a partir dos dados de entrada do usuário
     * @return
     */
    public Agencia buscarAgencia() {
        return buscarAgenciaPorReferencia(colherReferenciaParaBusca());
    }

    /**
     * Colhe o código da agência pretendida
     *
     * @return código da agência pretendida
     */
    public Integer colherCodigoAgencia() {
        Scanner leitor = new Scanner(System.in);
        return Leitura.lerCampoIntegerObrigatorio("Código da agência: ");
    }

    /**
     * Colhe o nome da agência pretendida
     *
     * @return nome da agência pretendida
     */
    public String colherNomeAgencia() {
        Scanner leitor = new Scanner(System.in);
        return Leitura.lerCampoStringObrigatorio("Nome da agência: ");
    }

    /**
     * Exibe a agência buscada, caso a mesma tenha sido encontrada
     *
     * @param agencia a ser exibida
     */
    public void exibirAgencia(Agencia agencia) {
        if (agencia != null) {
            System.out.println(agencia.toString());
        }
    }

    /**
     * Colhe a referência que será utilizada na busca da agência (nome ou código )
     *
     * @return referência que será utilizada na busca da agência (nome ou código)
     */
    public OpcaoMenu colherReferenciaParaBusca() {
        Scanner leitor = new Scanner(System.in);
        OpcaoMenu opcao = CONTINUE;
        ArrayList<OpcaoMenu> opcoesDisponiveis = new ArrayList<>();
        opcoesDisponiveis.add(A);
        opcoesDisponiveis.add(B);

        while (!opcoesDisponiveis.contains(opcao)) {
            System.out.println("Escolha a referência a ser utilizada no processo:\nA - Código\nB - Nome");
            opcao = Leitura.lerOpcaoMenu(leitor);
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
     * Interpreta a opcao escolhida a fim de redirecionar a busca segundo a referência correspondente
     *
     * @param opcao  correspondente a escolha da referência utilizada para a consulta
     * @return agencia encontrada, caso a mesma exista
     */
    public Agencia buscarAgenciaPorReferencia(OpcaoMenu opcao){

        if (isA(opcao)) { // Parâmetro de busca: Código
            return buscarAgenciaPorCodigo(colherCodigoAgencia());
        } else { // Parâmetro de busca: Nome
            return buscarAgenciaPorNome(colherNomeAgencia());
        }

    }

    /**
     * Confere a responsabilidade de buscar uma agência a partir de seu nome à service correspondente
     *
     * @param nomeAgencia utilizada como referência na busca
     * @return agencia com o nome informado, caso a mesma exista
     * @throws FalhaBuscaException caso alguma falha ocorra no processo
     */
    Agencia buscarAgenciaPorNome(String nomeAgencia) {
        Agencia agencia = null;
        try {
            agencia = agenciaService.buscarAgenciaPorNome(nomeAgencia);
        } catch (FalhaBuscaException e) {
            e.getMessage();
        }
        return agencia;
    }

    /**
     * Confere a responsabilidade de buscar uma agência a partir de seu código à service correspondente
     *
     * @param codigoAgencia utilizado como referência na busca
     * @return agencia com o código informado, caso a mesma exista
     * @throws FalhaBuscaException caso alguma falha ocorra no processo
     */
    Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) {
        Agencia agencia = null;
        try {
             agenciaService.buscarAgenciaPorCodigo(codigoAgencia);
        } catch (FalhaBuscaException e) {
            e.getMessage();
        }
        return agencia;
    }

    /**
     * Exibe o menu indicado
     *
     * @param menu indicado
     */
    public void exibirMenu(String menu) {
        System.out.println(menu);
    }
}
