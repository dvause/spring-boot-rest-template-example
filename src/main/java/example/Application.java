package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"example"})
@PropertySource({"classpath:application.properties"})
public class Application {

	@Autowired
	private Environment env;

	@Bean(name = "gitHubuserApiUrl")
	public String gitHubUserApiUrl() {
		return env.getProperty("api.github.user.url");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
