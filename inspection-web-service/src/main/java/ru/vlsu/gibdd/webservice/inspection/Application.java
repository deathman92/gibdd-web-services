package ru.vlsu.gibdd.webservice.inspection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
		ru.vlsu.gibdd.webservice.common.Package.class,
		ru.vlsu.gibdd.webservice.inspection.Application.class
})
@EntityScan(basePackageClasses = {
		ru.vlsu.gibdd.webservice.common.Package.class,
		ru.vlsu.gibdd.webservice.inspection.Application.class
})
@EnableJpaRepositories(basePackageClasses = {
		ru.vlsu.gibdd.webservice.common.Package.class,
		ru.vlsu.gibdd.webservice.inspection.Application.class
})
@EnableTransactionManagement
@EnableCaching
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
