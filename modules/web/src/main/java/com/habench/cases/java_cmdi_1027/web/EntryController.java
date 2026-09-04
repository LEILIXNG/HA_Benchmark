package com.habench.cases.java_cmdi_1027.web;

import com.habench.cases.java_cmdi_1027.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1027EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1027")
    public String handle(
            @RequestParam("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
