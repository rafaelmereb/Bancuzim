package bancuzim.repository;

import bancuzim.entity.Agencia;
import org.springframework.data.repository.CrudRepository;

public interface AgenciaRepository extends CrudRepository<Agencia, Integer>{
    Agencia findByNome(String nome);
    Agencia findByCodigo(Integer codigo);
    Agencia findByEndereco(String endereco);

    void deleteAgenciaByNome(String nome);
    void deleteAgenciaByCodigo(Integer id);
}
