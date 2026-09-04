package com.habench.cases.java_cmdi_1016.web;

import com.habench.cases.java_cmdi_1016.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1016EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1016")
    public String handle(
            @RequestParam("target") String target) {
        Step00.apply(target);
        return "ok";
    }
}
