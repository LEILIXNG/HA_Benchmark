package com.habench.cases.java_sqli_1061_n.web;

import com.habench.cases.java_sqli_1061_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1061_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1061_n/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
