package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.interfaces.ViewAtualizarInterface;
import bancuzim.util.Menu;

public class ViewAtualizarCliente extends ViewGerenciarClientes implements ViewAtualizarInterface {

    /**
     * "Carrega" a View responsável por atualizar clientes
     */
    public void load() {
        exibirMenu(Menu.ATUALIZAR_CLIENTE);
        manterViewAtualizarCliente();
    }

    /**
     * Mantém a View responsável por atualizar clientes
     */
    private void manterViewAtualizarCliente() {
         try {
            atualizarDados(buscarCliente());
            System.out.println("Cliente atualizado com sucesso!");
        } catch (FalhaAtualizacaoException e) {
            System.out.println(e.getMessage());
        }

    }

    private void atualizarDados(Cliente cliente) throws FalhaAtualizacaoException {
        if (cliente != null) {
            System.out.println("\n##### Digite os novos dados #####");
            Cliente clienteAtualizado = colherDadosDeCliente();

            //Setando os novos dados no registro já presente:
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpfCnpj(clienteAtualizado.getCpfCnpj());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setData_de_nascimento(clienteAtualizado.getData_de_nascimento());
            cliente.setSexo(clienteAtualizado.getSexo());

            //Atualizando cliente:
            atualizarCliente(cliente);
        }
    }

    /**
     * Confere a responsabilidade de atualizar um cliente específico à service correspondente
     *
     * @param cliente com os dados atualizados
     * @throws FalhaAtualizacaoException caso uma falha ocorra no processo
     */
    private void atualizarCliente(Cliente cliente) throws FalhaAtualizacaoException {
        clienteService.atualizarCliente(cliente);
    }
}
