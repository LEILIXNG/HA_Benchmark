package com.habench.cases.java_sqli_1056.web;

import com.habench.cases.java_sqli_1056.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1056EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1056/{category}")
    public String handle(
            @PathVariable("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
