package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
