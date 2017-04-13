package bancuzim.repository;

import bancuzim.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
    Cliente findByCpfCnpj(String cpfCnpj);

    void deleteClienteByNome(String nome);
    void deleteClienteByCpfCnpj(String cpf_cnpj);
}
