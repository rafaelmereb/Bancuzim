package bancuzim.interfaces.gerenciadores;

import bancuzim.model.Emprestimo;

import java.util.List;

public interface GerenciadorEmprestimoInterface {

    void cadastrarEmprestimo();

    Emprestimo buscarEmprestimo();

    void atualizarEmprestimo();

    void deletarEmprestimo();

    List listarEmprestimos();

    void importarEmprestimos();

}
