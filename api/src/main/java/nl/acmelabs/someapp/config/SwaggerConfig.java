package nl.acmelabs.someapp.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Slf4j
//@Configuration
//@EnableSwagger2
//@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

    // http://localhost:8080/v2/api-docs
    // http://localhost:8080/swagger-ui/
    @Bean
    public Docket api() {
        log.info("Configuring Swagger Config For SpringDataRestApplication2");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

