package com.habench.cases.java_cmdi_1000_n.web;

import com.habench.cases.java_cmdi_1000_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1000_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1000_n/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Gateway00.apply(query);
        return "ok";
    }
}
