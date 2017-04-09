package bancuzim.config;

import bancuzim.service.AgenciaService;
import bancuzim.view.ViewMenuPrincipal;
import bancuzim.view.agencia.ViewBuscarAgencia;
import bancuzim.view.agencia.ViewCadastrarAgencia;
import bancuzim.view.agencia.ViewGerenciarAgencias;
import bancuzim.view.cliente.ViewGerenciarClientes;
import bancuzim.view.conta.ViewGerenciarContas;
import bancuzim.view.emprestimo.ViewGerenciarEmprestimos;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {

    @Bean
    public ViewMenuPrincipal viewMenuPrincipal(){
        return new ViewMenuPrincipal();
    }

    /************************************************** AGÊNCIA **************************************************/


    @Bean
    public AgenciaService agenciaService(){
        return new AgenciaService();
    }


    @Bean
    public ViewGerenciarAgencias viewGerenciarAgencias(){
        return new ViewGerenciarAgencias();
    }

    @Bean
    ViewCadastrarAgencia viewCadastrarAgencia(){
        return new ViewCadastrarAgencia();
    }

    @Bean
    ViewBuscarAgencia viewBuscarAgencia(){
        return new ViewBuscarAgencia();
    }

    /************************************************** CLIENTE **************************************************/


    @Bean
    ViewGerenciarClientes viewGerenciarClientes(){
        return new ViewGerenciarClientes();
    }


    /************************************************** CONTA **************************************************/


    @Bean
    ViewGerenciarContas viewGerenciarContas(){
        return new ViewGerenciarContas();
    }


    /************************************************** EMPRESTIMO **************************************************/

    @Bean
    ViewGerenciarEmprestimos viewGerenciarEmprestimos(){
        return new ViewGerenciarEmprestimos();
    }
}
