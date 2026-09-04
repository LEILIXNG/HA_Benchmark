package com.habench.cases.java_sqli_1061.web;

import com.habench.cases.java_sqli_1061.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1061EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1061/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
