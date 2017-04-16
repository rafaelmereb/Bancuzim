package bancuzim.repository;

import bancuzim.entity.Emprestimo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Integer> {
    Emprestimo findByCliente_CpfCnpj(String cpfCnpj);

    List<Emprestimo> findAllByCliente_Nome(String nomeCliente);

    void deleteByCliente_CpfCnpj(String cpfCnpj);
}