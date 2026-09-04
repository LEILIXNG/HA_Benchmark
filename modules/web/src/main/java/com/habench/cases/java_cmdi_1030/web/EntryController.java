package com.habench.cases.java_cmdi_1030.web;

import com.habench.cases.java_cmdi_1030.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1030EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1030/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Step00.apply(tag);
        return "ok";
    }
}
