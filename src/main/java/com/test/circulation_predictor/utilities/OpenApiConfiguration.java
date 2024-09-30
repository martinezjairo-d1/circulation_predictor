package com.test.circulation_predictor.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;

/**
 * Open-Api (Swagger) configuration class.
 * This class configure the documentation general information.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
@Configuration
public class OpenApiConfiguration {

	@Value("${name.api}")
	private String nameApi;

	@Value("${description.api}")
	private String descriptionApi;

	@Value("${repo.url.api}")
	private String repoUrl;

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title(this.nameApi).version("1.0").description(descriptionApi))
				.externalDocs(new ExternalDocumentation().description("GitHub Repository").url(repoUrl));
	}

}
