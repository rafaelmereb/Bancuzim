package bancuzim.repository;

import bancuzim.entity.Agencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Interface que definirá os métodos de acesso ao banco para operações do tipo CRUD(correspondente ao padrão DAO).
 */
@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Integer>{
    Agencia findByNome(String nome);
    Agencia findByCodigo(Integer codigo);
    Agencia findByEndereco(String endereco);

    void deleteAgenciaByNome(String nome);
    void deleteAgenciaByCodigo(Integer id);
}
