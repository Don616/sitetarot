package don616.apitarot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlController {


    @RequestMapping("/docs")
    public void apiDocumentation(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui/index.html");
    }
}
