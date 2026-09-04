package com.habench.cases.java_sqli_1071.web;

import com.habench.cases.java_sqli_1071.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1071EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1071")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Step00.apply(token);
        return "ok";
    }
}
