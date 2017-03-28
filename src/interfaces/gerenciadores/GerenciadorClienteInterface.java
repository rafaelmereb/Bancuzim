package interfaces.gerenciadores;

import entidades.Cliente;

import java.util.List;

public interface GerenciadorClienteInterface {

    void cadastrarCliente();

    Cliente buscarCliente();

    void atualizarCliente();

    void deletarCliente();

    List listarClientes();

    void importarClientes();

}
