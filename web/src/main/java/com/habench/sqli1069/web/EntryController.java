package com.habench.sqli1069.web;

import com.habench.sqli1069.web.Sanitizer00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1069EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1069")
    public String handle(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        Sanitizer00.apply(query);
        return "ok";
    }
}
