package consulting.caimantech.contratos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoContratosApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {	
		System.setProperty("server.servlet.context-path", "/DemoContratos");
		SpringApplication.run(DemoContratosApplication.class, args);
	}
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(DemoContratosApplication.class);
	 }


}
