package com.habench.cases.java_cmdi_1025.web;

import com.habench.cases.java_cmdi_1025.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1025EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1025/{category}")
    public String handle(
            @PathVariable("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
