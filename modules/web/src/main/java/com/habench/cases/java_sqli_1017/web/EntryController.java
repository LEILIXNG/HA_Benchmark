package com.habench.cases.java_sqli_1017.web;

import com.habench.cases.java_sqli_1017.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1017EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1017/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Gateway00.apply(label);
        return "ok";
    }
}
