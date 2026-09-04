package com.habench.cases.java_sqli_1043.web;

import com.habench.cases.java_sqli_1043.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1043EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1043/{reference}")
    public String handle(
            @PathVariable("reference") String reference) {
        Step00.apply(reference);
        return "ok";
    }
}
