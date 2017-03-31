package bancuzim.interfaces.gerenciadores;

import bancuzim.model.Conta;

import java.util.List;

public interface GerenciadorContaInterface {

    void cadastrarConta();

    Conta buscarConta();

    void atualizarConta();

    void deletarConta();

    List listarContas();

    void importarContas();

}
