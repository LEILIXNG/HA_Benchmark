package com.habench.cases.java_sqli_1026_n.web;

import com.habench.cases.java_sqli_1026_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1026_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1026_n/{reference}")
    public String handle(
            @PathVariable("reference") String reference) {
        Step00.apply(reference);
        return "ok";
    }
}
