package bancuzim.view.cliente;

import bancuzim.entity.Cliente;
import bancuzim.enums.OpcaoMenu;
import bancuzim.exception.busca.FalhaBuscaException;
import bancuzim.exception.delecao.FalhaDelecaoException;
import bancuzim.interfaces.ViewDeletarInterface;
import bancuzim.util.Menu;

import java.util.List;

public class ViewDeletarCliente extends ViewGerenciarClientes implements ViewDeletarInterface{
    /**
     * "Carrega" a View responsável por deletar clientes
     */
    public void load() {
        exibirMenu(Menu.DELETAR_CLIENTE);
        manterViewDeletarCliente();
    }

    /**
     * Mantém a view responsável por deletar clientes
     */
    private void manterViewDeletarCliente() {
        deletarClienteSegundoReferencia(colherReferenciaParaBusca("CPF/CNPJ", "Nome"));
    }

    /**
     * Redireciona a forma de deleção a partir da referência escolhida pelo usuário (CPF/CNPJ ou Nome)
     * @param opcaoMenu correspondente à referência escolhida pelo usuário para futura deleção
     */
    private void deletarClienteSegundoReferencia(OpcaoMenu opcaoMenu) {
        switch (opcaoMenu){
            case A:
                deletarClientePorCpfCnpj(colherCpfCnpjCliente());
                break;
            case B:
                deletarClientePorNome(colherNomeCliente());
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    /**
     * Confere a responsabilidade de deletar um cliente pelo seu respectivo CPF/CNPJ à service correspondente
     * @param cpfCnpj utilizado como referência para a deleção
     */
    private void deletarClientePorCpfCnpj(String cpfCnpj) {
        try{
            clienteService.deletarClientePorCpfCnpj(cpfCnpj);
        }catch (FalhaDelecaoException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Confere a responsabilidade de deletar um cliente pelo seu respectivo nome à service correspondente
     * Como pode haver mais de um cliente com mesmo nome, será escolhido o cliente pelo qual será realizada a operação
     *
     * @param nome utilizado como referência para a deleção
     */
    private void deletarClientePorNome(String nome) {
        try{
            List<Cliente> clientes = clienteService.buscarClientesPorNome(nome);
            clienteService.deletarCliente(escolherClienteDesejado(clientes).getId());
        }catch (FalhaDelecaoException e){
            System.out.println(e.getMessage());
        } catch (FalhaBuscaException e) {
            e.printStackTrace();
        }
    }

}
