package com.habench.cases.java_sqli_1038.web;

import com.habench.cases.java_sqli_1038.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1038EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1038")
    public String handle(
            @RequestParam("userName") String userName) {
        Gateway00.apply(userName);
        return "ok";
    }
}
