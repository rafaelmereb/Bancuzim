package bancuzim.abstracts.repository;

import bancuzim.repository.AgenciaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class AgenciaRepositoryTest {

   @Autowired
   private AgenciaRepository agenciaRepository;

    @Test
    public void salvarTest() throws Exception {

    }

    @Test
    public void buscarPorIdTest() throws Exception {

    }


}
