package com.habench.cases.java_cmdi_1039.web;

import com.habench.cases.java_cmdi_1039.service.Gateway00;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1039EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1039")
    public String handle(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        Gateway00.apply(token);
        return "ok";
    }
}
