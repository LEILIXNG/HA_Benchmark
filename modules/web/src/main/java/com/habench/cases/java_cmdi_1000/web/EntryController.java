package com.habench.cases.java_cmdi_1000.web;

import com.habench.cases.java_cmdi_1000.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1000EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1000/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Gateway00.apply(query);
        return "ok";
    }
}
