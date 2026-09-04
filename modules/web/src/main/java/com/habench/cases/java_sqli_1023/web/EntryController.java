package com.habench.cases.java_sqli_1023.web;

import com.habench.cases.java_sqli_1023.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1023EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1023/{resource}")
    public String handle(
            @PathVariable("resource") String resource) {
        Step00.apply(resource);
        return "ok";
    }
}
