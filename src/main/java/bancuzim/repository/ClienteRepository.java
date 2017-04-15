package bancuzim.repository;

import bancuzim.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Cliente findByCpfCnpj(String cpfCnpj);
    List<Cliente> findAllByNome (String nome);

    void deleteClienteByCpfCnpj(String cpf_cnpj);
}
