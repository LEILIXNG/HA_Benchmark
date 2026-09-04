package com.habench.cases.java_sqli_1024.web;

import com.habench.cases.java_sqli_1024.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1024EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1024")
    public String handle(
            @RequestParam("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
