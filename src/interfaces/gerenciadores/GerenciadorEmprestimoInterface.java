package interfaces.gerenciadores;

import entidades.Emprestimo;

import java.util.List;

public interface GerenciadorEmprestimoInterface {

    void cadastrarEmprestimo();

    Emprestimo buscarEmprestimo();

    void atualizarEmprestimo();

    void deletarEmprestimo();

    List listarEmprestimos();

    void importarEmprestimos();

}
