package com.habench.cases.java_cmdi_1065.web;

import com.habench.cases.java_cmdi_1065.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1065EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1065/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Gateway00.apply(target);
        return "ok";
    }
}
