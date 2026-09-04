package com.habench.cases.java_sqli_1049.web;

import com.habench.cases.java_sqli_1049.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1049EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1049/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Gateway00.apply(userName);
        return "ok";
    }
}
