package com.habench.cases.java_sqli_1002.web;

import com.habench.cases.java_sqli_1002.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1002EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1002")
    public String handle(
            @RequestParam("tag") String tag) {
        Gateway00.apply(tag);
        return "ok";
    }
}
