package com.habench.cases.java_sqli_1021.web;

import com.habench.cases.java_sqli_1021.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1021EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1021/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Gateway00.apply(token);
        return "ok";
    }
}
