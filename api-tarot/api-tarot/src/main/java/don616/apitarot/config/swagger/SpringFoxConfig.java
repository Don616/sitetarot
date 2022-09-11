package don616.apitarot.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket swagger(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @RequestMapping("/docs")
    public void apiDocumentation1(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui/index.html");
    }

    @RequestMapping("/doc")
    public void apiDocumentation2(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui/index.html");
    }

    @RequestMapping("/api")
    public void apiDocumentation3(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui/index.html");
    }

}
