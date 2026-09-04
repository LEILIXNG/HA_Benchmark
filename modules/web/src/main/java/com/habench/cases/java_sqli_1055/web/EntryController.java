package com.habench.cases.java_sqli_1055.web;

import com.habench.cases.java_sqli_1055.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1055EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1055")
    public String handle(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        Step00.apply(resource);
        return "ok";
    }
}
