package com.habench.cases.java_sqli_1031.web;

import com.habench.cases.java_sqli_1031.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1031EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1031/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Step00.apply(keyword);
        return "ok";
    }
}
