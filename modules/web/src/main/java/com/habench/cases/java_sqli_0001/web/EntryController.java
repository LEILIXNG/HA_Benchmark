package com.habench.cases.java_sqli_0001.web;

import com.habench.cases.java_sqli_0001.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_0001EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_0001")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Step00.apply(keyword);
        return "ok";
    }
}
