package com.taller.dos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.taller.dos.products","com.taller.dos.orders"})
@ComponentScan({"com.taller.dos.products", "com.taller.dos.orders"})
@EntityScan({"com.taller.dos.products.commons", "com.taller.dos.orders.commons"})
@EnableJpaRepositories({"com.taller.dos.products.queries.domain", "com.taller.dos.products.commands.domain"})
public class SalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

}
