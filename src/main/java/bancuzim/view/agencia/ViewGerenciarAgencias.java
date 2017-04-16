package bancuzim.view.agencia;


import bancuzim.entity.Agencia;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.service.AgenciaService;
import bancuzim.util.Menu;
import bancuzim.view.ViewMenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static bancuzim.enums.OpcaoMenu.*;
import static bancuzim.util.Leitura.*;

/**
 * View correspondente à gerência de agências
 */
public class ViewGerenciarAgencias extends ViewMenuPrincipal {

    @Autowired
    @Qualifier("agenciaService")
    AgenciaService agenciaService;
    @Autowired
    @Qualifier("viewCadastrarAgencia")
    ViewCadastrarAgencia viewCadastrarAgencia;
    @Autowired
    @Qualifier("viewBuscarAgencia")
    ViewBuscarAgencia viewBuscarAgencia;
    @Autowired
    @Qualifier("viewAtualizarAgencia")
    ViewAtualizarAgencia viewAtualizarAgencia;
    @Autowired
    @Qualifier("viewDeletarAgencia")
    ViewDeletarAgencia viewDeletarAgencia;
    @Autowired
    @Qualifier("viewListarAgencias")
    ViewListarAgencias viewListarAgencias;
    @Autowired
    @Qualifier("viewImportarAgencias")
    ViewImportarAgencias viewImportarAgencias;

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
            opcao = lerOpcaoMenu();
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

        agencia.setCodigo(lerCampoIntegerObrigatorio("Código da Agência: "));
        agencia.setNome(lerCampoStringObrigatorio("Nome da Agência: "));
        agencia.setGerente(lerCampoStringObrigatorio("Nome do Gerente da Agência: "));
        agencia.setEndereco(lerCampoStringObrigatorio("Endereço da Agência: "));

        return agencia;
    }

    /**
     * Método responsável por buscar uma agência a partir dos dados de entrada do usuário
     *
     * @return agência buscada
     */
    public Agencia buscarAgencia() throws FalhaBuscaException {
        return buscarAgenciaPorReferencia(colherReferenciaEntreDuasOpcoes("Código", "Nome"));
    }

    /**
     * Colhe o código da agência pretendida
     *
     * @return código da agência pretendida
     */
    public Integer colherCodigoAgencia() {
        return lerCampoIntegerObrigatorio("Código da agência: ");
    }

    /**
     * Colhe o nome da agência pretendida
     *
     * @return nome da agência pretendida
     */
    public String colherNomeAgencia() {
        return lerCampoStringObrigatorio("Nome da agência: ");
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
    public Agencia buscarAgenciaPorReferencia(OpcaoMenu opcao) throws FalhaBuscaException {

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
    public Agencia buscarAgenciaPorNome(String nomeAgencia) throws FalhaBuscaException {
        return agenciaService.buscarAgenciaPorNome(nomeAgencia);
    }

    /**
     * Confere a responsabilidade de buscar uma agência a partir de seu código à service correspondente
     *
     * @param codigoAgencia utilizado como referência na busca
     * @return agencia com o código informado, caso a mesma exista
     */
    public Agencia buscarAgenciaPorCodigo(Integer codigoAgencia) throws FalhaBuscaException {
        return agenciaService.buscarAgenciaPorCodigo(codigoAgencia);
    }
}
