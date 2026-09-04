package com.habench.cases.java_sqli_1069.web;

import com.habench.cases.java_sqli_1069.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1069EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1069/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Gateway00.apply(tag);
        return "ok";
    }
}
