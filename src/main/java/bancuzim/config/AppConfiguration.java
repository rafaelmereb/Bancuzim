package bancuzim.config;

import bancuzim.service.AgenciaService;
import bancuzim.view.ViewMenuPrincipal;
import bancuzim.view.agencia.*;
import bancuzim.view.cliente.*;
import bancuzim.view.conta.ViewGerenciarContas;
import bancuzim.view.emprestimo.ViewGerenciarEmprestimos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    /********************************************** MENU PRINCIPAL ***********************************************/

    @Bean(name = "viewMenuPrincipal")
    public ViewMenuPrincipal viewMenuPrincipal() {
        return new ViewMenuPrincipal();
    }

    /************************************************** AGÊNCIA **************************************************/

    @Bean(name = "agenciaService")
    public AgenciaService agenciaService() {
        return new AgenciaService();
    }

    @Bean(name = "viewGerenciarAgencias")
    public ViewGerenciarAgencias viewGerenciarAgencias() {
        return new ViewGerenciarAgencias();
    }

    @Bean(name = "viewCadastrarAgencia")
    ViewCadastrarAgencia viewCadastrarAgencia() {
        return new ViewCadastrarAgencia();
    }

    @Bean(name = "viewBuscarAgencia")
    ViewBuscarAgencia viewBuscarAgencia() {
        return new ViewBuscarAgencia();
    }

    @Bean(name = "viewAtualizarAgencia")
    ViewAtualizarAgencia viewAtualizarAgencia() {
        return new ViewAtualizarAgencia();
    }

    @Bean(name = "viewDeletarAgencia")
    ViewDeletarAgencia viewDeletarAgencia() {
        return new ViewDeletarAgencia();
    }

    @Bean(name = "viewImportarAgencias")
    ViewImportarAgencias viewImportarAgencias() {
        return new ViewImportarAgencias();
    }

    @Bean(name = "viewListarAgencias")
    ViewListarAgencias viewListarAgencias() {
        return new ViewListarAgencias();
    }

    /************************************************** CLIENTE **************************************************/

    @Bean(name = "viewGerenciarClientes")
    ViewGerenciarClientes viewGerenciarClientes() {
        return new ViewGerenciarClientes();
    }

    @Bean(name = "viewCadastrarCliente")
    ViewCadastrarCliente viewCadastrarCliente() {
        return new ViewCadastrarCliente();
    }

    @Bean(name = "viewBuscarCliente")
    ViewBuscarCliente viewBuscarCliente() {
        return new ViewBuscarCliente();
    }

    @Bean(name = "viewImportarClientes")
    ViewImportarClientes viewImportarClientes() {
        return new ViewImportarClientes();
    }

    @Bean(name = "viewListarClientes")
    ViewListarClientes viewListarClientes() {
        return new ViewListarClientes();
    }

    @Bean(name = "viewDeletarCliente")
    ViewDeletarCliente viewDeletarCliente() {
        return new ViewDeletarCliente();
    }

    @Bean(name = "viewAtualizarCliente")
    ViewAtualizarCliente viewAtualizarCliente() {
        return new ViewAtualizarCliente();
    }

    /**************************************************  CONTA  **************************************************/

    @Bean(name = "viewGerenciarContas")
    ViewGerenciarContas viewGerenciarContas() {
        return new ViewGerenciarContas();
    }

    /************************************************ EMPRESTIMO ************************************************/

    @Bean(name = "viewGerenciarEmprestimos")
    ViewGerenciarEmprestimos viewGerenciarEmprestimos() {
        return new ViewGerenciarEmprestimos();
    }
}
