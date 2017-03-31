package bancuzim.interfaces.repository;

import bancuzim.enums.Sexo;
import bancuzim.modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class ClienteRepositoryInterfaceTest {

   @Autowired
   private ClienteRepositoryInterface clienteRepositoryInterface;

    @Test
    public void salvarTest() throws Exception {
        String cpf_cnpj = "999.999.999-99";
        String nome = "NOME QUALQUER";
        String endereco = "ENDEREÇO QUALQUER";
        String data_de_nascimento = "03-05-1995";
        Sexo sexo = Sexo.MASCULINO;
        Cliente cliente = new Cliente( nome, cpf_cnpj, endereco, data_de_nascimento, sexo);
        Cliente clienteSalvo = clienteRepositoryInterface.save(cliente);


        assertEquals(cliente.getCpf_cnpj(), clienteSalvo.getCpf_cnpj());
    }

    @Test
    public void buscarPorIdTest() throws Exception {

    }


}
