package pl.manczak.restapi_nullpointer.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class Config{
   public Docket swaggerAi(){
       return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .paths(PathSelectors.regex("^(?!/(error).*$).*$"))
               .build();
   }
    }

//public class SwaggerConfiguration {
//
//    public Docket getDocket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("pl.manczak.restapi_nullpointer"))
//                .build()
//                .apiInfo(apiInfo())
//                .securitySchemes(Arrays.asList(apikey()));
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("Sig-Predict REST API Document")
//                .description("work in progres")
//                .termsOfServiceUrl("localhost")
//                .version("1.0")
//                .build();
//    }
//
//    private ApiKey apikey(){
//        return new ApiKey("jwtToken", "Authorization", "header");
//    }
//}
