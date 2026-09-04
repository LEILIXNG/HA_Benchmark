package com.habench.cases.java_cmdi_1012.web;

import com.habench.cases.java_cmdi_1012.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1012EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1012")
    public String handle(
            @RequestParam("query") String query) {
        Step00.apply(query);
        return "ok";
    }
}
