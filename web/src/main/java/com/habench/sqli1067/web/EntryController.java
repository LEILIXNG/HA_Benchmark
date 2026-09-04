package com.habench.sqli1067.web;

import com.habench.sqli1067.web.Stage00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1067EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1067")
    public String handle(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        Stage00.handle(query);
        return "ok";
    }
}
