package com.kb.dndchar;

import com.kb.dndchar.accessors.IPlayerCharacterAccessor;
import com.kb.dndchar.accessors.IUserAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner startup(IPlayerCharacterAccessor playerCharacterAccessor, IUserAccessor userAccessor) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                LOGGER.info("All the Users: {}", playerCharacterAccessor.findAll());
                LOGGER.info("All the Characters: {}", userAccessor.findAll());
            }
        };
    }
}
