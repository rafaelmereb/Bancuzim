package bancuzim.interfaces.gerenciadores;

import bancuzim.model.Agencia;

import java.util.List;

public interface GerenciadorAgenciaInterface {

    void cadastrarAgencia();

    Agencia buscarAgenda();

    void atualizarAgencia();

    void deletarAgencia();

    List listarAgencias();

    void importarAgencias();

}