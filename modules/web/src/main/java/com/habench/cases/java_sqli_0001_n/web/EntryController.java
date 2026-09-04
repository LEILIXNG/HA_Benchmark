package com.habench.cases.java_sqli_0001_n.web;

import com.habench.cases.java_sqli_0001_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_0001_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_0001_n")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Step00.apply(keyword);
        return "ok";
    }
}
