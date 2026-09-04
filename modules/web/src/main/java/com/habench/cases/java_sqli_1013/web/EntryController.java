package com.habench.cases.java_sqli_1013.web;

import com.habench.cases.java_sqli_1013.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1013EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1013")
    public String handle(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        Gateway00.apply(reference);
        return "ok";
    }
}
