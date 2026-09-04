package com.habench.cases.java_sqli_1032.web;

import com.habench.cases.java_sqli_1032.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1032EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1032/{reference}")
    public String handle(
            @PathVariable("reference") String reference) {
        Step00.apply(reference);
        return "ok";
    }
}
