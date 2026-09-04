package com.habench.cases.java_cmdi_1020.web;

import com.habench.cases.java_cmdi_1020.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1020EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1020/{resource}")
    public String handle(
            @PathVariable("resource") String resource) {
        Step00.apply(resource);
        return "ok";
    }
}
