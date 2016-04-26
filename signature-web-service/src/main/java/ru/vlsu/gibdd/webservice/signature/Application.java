package ru.vlsu.gibdd.webservice.signature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
		ru.vlsu.gibdd.webservice.common.Package.class,
		ru.vlsu.gibdd.webservice.signature.Application.class
})
@EntityScan(basePackageClasses = {
		ru.vlsu.gibdd.webservice.signature.Application.class
})
@EnableJpaRepositories(basePackageClasses = {
		ru.vlsu.gibdd.webservice.signature.Application.class
})
@EnableJpaAuditing
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
