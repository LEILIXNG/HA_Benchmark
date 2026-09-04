package com.habench.cases.java_cmdi_0002.web;

import com.habench.cases.java_cmdi_0002.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_0002EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_0002/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Step00.apply(target);
        return "ok";
    }
}
