package com.habench.cases.java_sqli_1001.web;

import com.habench.cases.java_sqli_1001.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1001EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1001")
    public String handle(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        Step00.apply(category);
        return "ok";
    }
}
