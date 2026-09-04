package com.habench.cases.java_sqli_1028.web;

import com.habench.cases.java_sqli_1028.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1028EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1028")
    public String handle(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        Step00.apply(filename);
        return "ok";
    }
}
