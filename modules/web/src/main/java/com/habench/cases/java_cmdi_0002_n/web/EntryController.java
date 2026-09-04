package com.habench.cases.java_cmdi_0002_n.web;

import com.habench.cases.java_cmdi_0002_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_0002_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_0002_n/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Step00.apply(target);
        return "ok";
    }
}
