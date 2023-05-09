package uz.pdp.crudwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "uz.pdp.crudwithspringboot.*")
public class CrudWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudWithSpringBootApplication.class, args);
    }

}
