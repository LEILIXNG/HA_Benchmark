package com.habench.cases.java_sqli_1029_n.web;

import com.habench.cases.java_sqli_1029_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1029_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1029_n/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Step00.apply(tag);
        return "ok";
    }
}
