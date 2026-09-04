package com.habench.cases.java_sqli_1007.web;

import com.habench.cases.java_sqli_1007.service.Sanitizer00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1007EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1007")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Sanitizer00.apply(token);
        return "ok";
    }
}
