package bancuzim.interfaces.DAO;

import java.util.List;

public interface DAOInterface{

    void salvar();
    Object procurarPorId();
    void atualizar();
    void remover();
    List listarTodos();

}
