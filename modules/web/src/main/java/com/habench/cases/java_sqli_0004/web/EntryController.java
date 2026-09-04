package com.habench.cases.java_sqli_0004.web;

import com.habench.cases.java_sqli_0004.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_0004EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_0004")
    public String handle(
            @RequestParam("q") String q) {
        Step00.apply(q);
        return "ok";
    }
}
