package bancuzim.config;

import bancuzim.service.AgenciaService;
import bancuzim.view.ViewMenuPrincipal;
import bancuzim.view.agencia.*;
import bancuzim.view.cliente.ViewGerenciarClientes;
import bancuzim.view.conta.ViewGerenciarContas;
import bancuzim.view.emprestimo.ViewGerenciarEmprestimos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    /********************************************** MENU PRINCIPAL ***********************************************/

    @Bean
    public ViewMenuPrincipal viewMenuPrincipal() {
        return new ViewMenuPrincipal();
    }

    /************************************************** AGÊNCIA **************************************************/


    @Bean
    public AgenciaService agenciaService() {
        return new AgenciaService();
    }


    @Bean
    public ViewGerenciarAgencias viewGerenciarAgencias() {
        return new ViewGerenciarAgencias();
    }

    @Bean
    ViewCadastrarAgencia viewCadastrarAgencia() {
        return new ViewCadastrarAgencia();
    }

    @Bean
    ViewBuscarAgencia viewBuscarAgencia() {
        return new ViewBuscarAgencia();
    }

    @Bean
    ViewAtualizarAgencia viewAtualizarAgencia() {
        return new ViewAtualizarAgencia();
    }

    @Bean
    ViewDeletarAgencia viewDeletarAgencia() {
        return new ViewDeletarAgencia();
    }

    @Bean
    ViewImportarAgencia viewImportarAgencia(){
        return new ViewImportarAgencia();
    }

    @Bean
    ViewListarAgencias viewListarAgencias() {
        return new ViewListarAgencias();
    }

    /************************************************** CLIENTE **************************************************/


    @Bean
    ViewGerenciarClientes viewGerenciarClientes() {
        return new ViewGerenciarClientes();
    }


    /**************************************************  CONTA  **************************************************/


    @Bean
    ViewGerenciarContas viewGerenciarContas() {
        return new ViewGerenciarContas();
    }


    /************************************************ EMPRESTIMO ************************************************/

    @Bean
    ViewGerenciarEmprestimos viewGerenciarEmprestimos() {
        return new ViewGerenciarEmprestimos();
    }
}
