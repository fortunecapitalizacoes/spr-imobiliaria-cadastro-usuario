package br.com.tbg.ptg.nominacao.spring;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API Nominação V2", version = "v1", description = "Documentação da API do Match-Engine"))
public class OpenApiConfig {
}
