package com.habench.cases.java_sqli_1060.web;

import com.habench.cases.java_sqli_1060.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1060EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1060")
    public String handle(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        Gateway00.apply(label);
        return "ok";
    }
}
