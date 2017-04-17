package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.exception.atualizacao.FalhaAtualizacaoException;
import bancuzim.exception.busca.FalhaBuscaException;
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
             try{
            atualizarDados(escolherClienteDesejado(buscarClientes()), colherDadosAtualizadosDeCliente());
            System.out.println("Cliente atualizado com sucesso!");
             } catch (FalhaBuscaException e) {
                 throw new FalhaAtualizacaoException(e.getEntidade(), e.getDescricaoFalha());
             }
         } catch (FalhaAtualizacaoException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Colhe dados atualizados de cliente
     * @return dados atualizados do cliente
     */
    private Cliente colherDadosAtualizadosDeCliente() {
        System.out.println("\n##### Digite os novos dados #####");
        return colherDadosDeCliente();
    }

    /**
     * Atualiza os dados de um cliente a partir de novos dados coletados
     * @param cliente a ser atualizado
     * @param clienteAtualizado dados atualizados do cliente
     * @throws FalhaAtualizacaoException caso alguma falha ocorra no processo
     */
    private void atualizarDados(Cliente cliente, Cliente clienteAtualizado) throws FalhaAtualizacaoException {
        if (cliente != null) {
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
