package com.habench.cases.java_sqli_1005.web;

import com.habench.cases.java_sqli_1005.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1005EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1005")
    public String handle(
            @RequestParam("resource") String resource) {
        Gateway00.apply(resource);
        return "ok";
    }
}
