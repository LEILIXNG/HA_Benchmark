package com.habench.cases.java_sqli_1072.web;

import com.habench.cases.java_sqli_1072.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1072EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1072/{resource}")
    public String handle(
            @PathVariable("resource") String resource) {
        Gateway00.apply(resource);
        return "ok";
    }
}
