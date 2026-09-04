package com.habench.cases.java_sqli_1021_n.web;

import com.habench.cases.java_sqli_1021_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1021_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1021_n/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Gateway00.apply(token);
        return "ok";
    }
}
