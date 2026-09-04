package com.habench.cases.java_sqli_1003.web;

import com.habench.cases.java_sqli_1003.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1003EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1003")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Step00.apply(filename);
        return "ok";
    }
}
