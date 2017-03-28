package in.mitransoftwares.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"in.mitransoftwares.ecommerce"})
public class SgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgmApplication.class, args);
	}
}
