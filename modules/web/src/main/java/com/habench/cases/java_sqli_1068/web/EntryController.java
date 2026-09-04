package com.habench.cases.java_sqli_1068.web;

import com.habench.cases.java_sqli_1068.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1068EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1068/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Step00.apply(target);
        return "ok";
    }
}
