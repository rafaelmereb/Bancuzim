package bancuzim;

import bancuzim.component.MainComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "bancuzim.repository")

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * Executa a aplicação SpringBoot
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        final ConfigurableApplicationContext contexto = SpringApplication.run(Application.class);
        contexto.getBean(MainComponent.class).run();
    }
}

