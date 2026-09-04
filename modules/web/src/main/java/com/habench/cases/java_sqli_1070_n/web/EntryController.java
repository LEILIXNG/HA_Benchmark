package com.habench.cases.java_sqli_1070_n.web;

import com.habench.cases.java_sqli_1070_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1070_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1070_n")
    public String handle(
            @RequestParam("token") String token) {
        Step00.apply(token);
        return "ok";
    }
}
