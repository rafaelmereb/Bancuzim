package bancuzim.interfaces.dao;

import bancuzim.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAOInterface extends JpaRepository<Cliente, String>{

    @Query("select cliente from Cliente cliente where cliente.cpf_cnpj=:cpf_cnpj")
    public Cliente buscarPorId(@Param("cpf_cnpj") String cpf_cnpj);

}
