package com.habench.cases.java_sqli_1054_n.web;

import com.habench.cases.java_sqli_1054_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1054_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1054_n")
    public String handle(
            @RequestParam("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
