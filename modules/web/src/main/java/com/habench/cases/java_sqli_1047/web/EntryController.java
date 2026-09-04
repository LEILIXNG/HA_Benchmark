package com.habench.cases.java_sqli_1047.web;

import com.habench.cases.java_sqli_1047.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1047EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1047/{resource}")
    public String handle(
            @PathVariable("resource") String resource) {
        Gateway00.apply(resource);
        return "ok";
    }
}
