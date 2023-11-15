package com.detabase.oneToMany.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@EnableOpenApi
@EnableScheduling
public class SwaggerConfig {

    @Bean
    public Docket api(){   // is k liye aik tu apring ka version 2.7.6 hona chahiye 3.0.2 per tu web on nhin ho rhi thi
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any()) //basePackage("com.detabase") in the place of any()
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {

        return new ApiInfo("detabase interface - Spring boot swagger configuration","\"swagger configuration for application\""
                ,"1.0","terms of service",new Contact("afham","www.google.com","mafham678@gmail.com")
                ,"License of api","api license url", Collections.emptyList());
//       return new ApiInfoBuilder()
//               .title("detabase interface - Spring boot swagger configuration ")
//               .description("\"swagger configuration for application\"")
//               .version("1.1.0")
//               .license("Apache 2.0")
//               .licenseUrl("https://www.apache.org/licenses/LICENSES-2.0\"")
//               .build();

    }

}
