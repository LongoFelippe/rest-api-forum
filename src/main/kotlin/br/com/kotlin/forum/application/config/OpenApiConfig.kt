package br.com.kotlin.forum.application.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class OpenApiConfig {

    @Bean
    fun storeConclusionBffOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("forum-rest-api - Kotlin")
                    .description("")
                    .version("0.0.1")
            )
    }

}