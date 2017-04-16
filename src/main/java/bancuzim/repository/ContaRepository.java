package bancuzim.repository;

import bancuzim.entity.Agencia;
import bancuzim.entity.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Integer>{
    Conta findContaByNumeroAndAgencia(String numero, Agencia agencia);
    void deleteContaByNumeroAndAgencia(String numero, Agencia agencia);
}
