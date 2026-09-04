package com.habench.cases.java_cmdi_1064.web;

import com.habench.cases.java_cmdi_1064.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1064EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1064/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Step00.apply(token);
        return "ok";
    }
}
