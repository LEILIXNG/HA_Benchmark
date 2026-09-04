package com.habench.cases.java_cmdi_1016_n.web;

import com.habench.cases.java_cmdi_1016_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1016_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1016_n")
    public String handle(
            @RequestParam("target") String target) {
        Step00.apply(target);
        return "ok";
    }
}
