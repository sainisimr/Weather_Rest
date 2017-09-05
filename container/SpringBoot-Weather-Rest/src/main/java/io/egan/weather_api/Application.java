package io.egan.weather_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.egan.weather_api.Config.SwaggerConfig;
import io.egan.weather_api.Config.WebConfig;


@Import({SwaggerConfig.class, WebConfig.class})
@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(Application.class, args);
	}

}
