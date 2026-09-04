package com.habench.cases.java_sqli_1039.web;

import com.habench.cases.java_sqli_1039.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1039EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1039")
    public String handle(
            @RequestParam("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
