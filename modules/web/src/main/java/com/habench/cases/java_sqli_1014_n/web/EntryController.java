package com.habench.cases.java_sqli_1014_n.web;

import com.habench.cases.java_sqli_1014_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1014_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1014_n")
    public String handle(
            @RequestParam("token") String token) {
        Gateway00.apply(token);
        return "ok";
    }
}
