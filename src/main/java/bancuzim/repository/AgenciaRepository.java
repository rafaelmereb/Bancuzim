package theBancuzim.repository;

import org.springframework.data.repository.CrudRepository;
import theBancuzim.entity.Agencia;

public interface AgenciaRepository extends CrudRepository<Agencia, Integer>{
    Agencia findByNome(String nome);
    Agencia findByCodigo(Integer codigo);
    Agencia findByEndereco(String endereco);

    void deleteAgenciaByNome(String nome);
    void deleteAgenciaByCodigo(Integer id);
}
