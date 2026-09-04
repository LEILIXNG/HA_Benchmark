package com.habench.cases.java_sqli_1058_n.web;

import com.habench.cases.java_sqli_1058_n.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1058_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1058_n")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Gateway00.apply(token);
        return "ok";
    }
}
