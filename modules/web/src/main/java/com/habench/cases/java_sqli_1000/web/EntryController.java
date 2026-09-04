package com.habench.cases.java_sqli_1000.web;

import com.habench.cases.java_sqli_1000.service.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1000EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1000/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Sanitizer00.apply(keyword);
        return "ok";
    }
}
