package com.example.searchservice.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.time.Duration;

@Configuration
@Slf4j
@EnableElasticsearchRepositories(basePackages = "com.example.searchservice.repository")
public class ElasticConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.hostandport}")
    private String hostAndPort;

    @Value("${elasticsearch.username}")
    private String username;

    @Value("${elasticsearch.password}")
    private String password;


    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(hostAndPort)
                .usingSsl()
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                .withBasicAuth(username, password)
                .build();
    }
}
