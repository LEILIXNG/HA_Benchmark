package com.habench.cases.java_sqli_1041.web;

import com.habench.cases.java_sqli_1041.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1041EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1041")
    public String handle(
            @RequestParam("token") String token) {
        Gateway00.apply(token);
        return "ok";
    }
}
