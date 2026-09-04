package com.habench.cases.java_sqli_1064_n.web;

import com.habench.cases.java_sqli_1064_n.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1064_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1064_n")
    public String handle(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        Step00.apply(label);
        return "ok";
    }
}
