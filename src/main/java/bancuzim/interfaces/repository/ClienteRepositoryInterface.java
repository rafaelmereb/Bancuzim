package bancuzim.interfaces.repository;

import bancuzim.modelo.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepositoryInterface extends CrudRepository<Cliente, String>  {

    @Query("select c from Cliente c where c.cpf_cnpj = :cpf_cnpj")
    public Cliente buscarPorId(@Param("cpf_cnpj") String cpf_cnpj);

    @Query("select c from Cliente c")
    List<Cliente> listarTodos();
}
