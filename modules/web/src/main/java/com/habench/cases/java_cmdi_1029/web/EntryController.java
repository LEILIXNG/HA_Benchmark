package com.habench.cases.java_cmdi_1029.web;

import com.habench.cases.java_cmdi_1029.web.Step00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1029EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1029")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Step00.apply(token);
        return "ok";
    }
}
