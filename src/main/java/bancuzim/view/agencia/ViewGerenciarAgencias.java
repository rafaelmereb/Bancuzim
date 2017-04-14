package bancuzim.view.agencia;


import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Leitura;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static bancuzim.enums.OpcaoMenu.*;

/**
 * View correspondente à gerência de agências
 */
public class ViewGerenciarAgencias extends ViewMenuPrincipal {

    @Autowired
    @Qualifier("viewCadastrarAgencia")
    private ViewCadastrarAgencia viewCadastrarAgencia;

    @Autowired
    @Qualifier("viewBuscarAgencia")
    private ViewBuscarAgencia viewBuscarAgencia;

    @Autowired
    @Qualifier("viewAtualizarAgencia")
    private ViewAtualizarAgencia viewAtualizarAgencia;

    @Autowired
    @Qualifier("viewDeletarAgencia")
    private ViewDeletarAgencia viewDeletarAgencia;

    @Autowired
    @Qualifier("viewListarAgencias")
    private ViewListarAgencias viewListarAgencias;

    @Autowired
    @Qualifier("viewImportarAgencias")
    private ViewImportarAgencias viewImportarAgencias;

    @Autowired
    @Qualifier("agenciaService")
    public AgenciaService agenciaService;

    public final String AGENCIA = Agencia.class.getSimpleName();

    public void load() {
        manterMenuGerenciarAgencias();
    }

    /**
     * Mantém o menu de gerência de agências enquanto a opção não for V (Voltar)
     */
    private void manterMenuGerenciarAgencias() {
        OpcaoMenu opcao = CONTINUE;

        while (notVoltar(opcao)) {
            exibirMenu(Menu.GERENCIAR_AGENCIAS);
            opcao = Leitura.lerOpcaoMenu();
            interpretarEntrada(opcao, viewCadastrarAgencia, viewBuscarAgencia, viewAtualizarAgencia, viewDeletarAgencia, viewListarAgencias, viewImportarAgencias);
        }
    }

    /**
     * Colhe dados da agência a ser cadastrada
     *
     * @return agencia cujos dados foram colhidos
     */
    public Agencia colherDadosDeAgencia() {
        Agencia agencia = new Agencia();

        agencia.setCodigo(Leitura.lerCampoIntegerObrigatorio("Código da Agência: "));
        agencia.setNome(Leitura.lerCampoStringObrigatorio("Nome da Agência: "));
        agencia.setGerente(Leitura.lerCampoStringObrigatorio("Nome do Gerente da Agência: "));
        agencia.setEndereco(Leitura.lerCampoStringObrigatorio("Endereço da Agência: "));

        return agencia;
    }

    /**
     * Método responsável por buscar uma agência a partir dos dados de entrada do usuário
     *
     * @return agência buscada
     */
    public Agencia buscarAgencia() {
        return buscarAgenciaPorReferencia(colherReferenciaParaBusca("Código", "Nome"));
    }

    /**
     * Colhe o código da agência pretendida
     *
     * @return código da agência pretendida
     */
    public Integer colherCodigoAgencia() {
                return Leitura.lerCampoIntegerObrigatorio("Código da agência: ");
    }

    /**
     * Colhe o nome da agência pretendida
     *
     * @return nome da agência pretendida
     */
    public String colherNomeAgencia() {
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
     * Interpreta a opcao escolhida a fim de redirecionar a busca segundo a referência correspondente
     *
     * @param opcao correspondente a escolha da referência utilizada para a consulta
     * @return agencia encontrada, caso a mesma exista
     */
    public Agencia buscarAgenciaPorReferencia(OpcaoMenu opcao) {

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
     */
    Agencia buscarAgenciaPorNome(String nomeAgencia) {
        Agencia agencia = null;
        try {
            agencia = agenciaService.buscarAgenciaPorNome(nomeAgencia);
        } catch (FalhaBuscaException e) {
            System.out.println(e.getMessage());
        }
        return agencia;
    }

    /**
     * Confere a responsabilidade de buscar uma agência a partir de seu código à service correspondente
     *
     * @param codigoAgencia utilizado como referência na busca
     * @return agencia com o código informado, caso a mesma exista
     */
    Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) {
        Agencia agencia = null;
        try {
            agencia = agenciaService.buscarAgenciaPorCodigo(codigoAgencia);
        } catch (FalhaBuscaException e) {
            System.out.println(e.getMessage());
        }
        return agencia;
    }
}
