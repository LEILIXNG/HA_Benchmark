package com.habench.cases.java_sqli_1054.web;

import com.habench.cases.java_sqli_1054.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1054EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1054")
    public String handle(
            @RequestParam("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
