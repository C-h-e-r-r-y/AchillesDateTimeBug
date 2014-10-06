package com.AchillesJsonType.configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import info.archinnov.achilles.persistence.PersistenceManager;
import info.archinnov.achilles.persistence.PersistenceManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AchillesPersistenceService {

    private String keyspaceName = "myKeySpace";

    private String host = "localhost";

    private int port = 9042;

    @Bean
    public PersistenceManager persistenceManager() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());

        Cluster cluster = Cluster.builder()
                .addContactPoints(host)
                .withPort(port)
                .withCompression(ProtocolOptions.Compression.NONE)
                .build();

        PersistenceManagerFactory persistenceManagerFactory = PersistenceManagerFactory.PersistenceManagerFactoryBuilder
                .builder(cluster)
                .withEntityPackages("com.AchillesJsonType")
                .withKeyspaceName(keyspaceName)
                .forceTableCreation(false)
                .withJacksonMapper(mapper)
                .build();

        return persistenceManagerFactory.createPersistenceManager();
    }
}
