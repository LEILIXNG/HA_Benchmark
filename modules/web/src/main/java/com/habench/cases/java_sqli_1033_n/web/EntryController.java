package com.habench.cases.java_sqli_1033_n.web;

import com.habench.cases.java_sqli_1033_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1033_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1033_n/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Step00.apply(query);
        return "ok";
    }
}
