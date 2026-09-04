package com.habench.cases.java_cmdi_1059.web;

import com.habench.cases.java_cmdi_1059.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1059EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1059/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
