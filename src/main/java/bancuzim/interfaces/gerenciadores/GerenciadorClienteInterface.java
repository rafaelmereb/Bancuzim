package bancuzim.interfaces.gerenciadores;

import bancuzim.model.Cliente;

import java.util.List;

public interface GerenciadorClienteInterface {

    void cadastrarCliente();

    Cliente buscarCliente();

    void atualizarCliente();

    void deletarCliente();

    List listarClientes();

    void importarClientes();

}
