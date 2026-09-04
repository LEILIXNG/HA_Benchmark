package com.habench.cases.java_sqli_1004.web;

import com.habench.cases.java_sqli_1004.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1004EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1004")
    public String handle(
            @RequestParam("query") String query) {
        Step00.apply(query);
        return "ok";
    }
}
