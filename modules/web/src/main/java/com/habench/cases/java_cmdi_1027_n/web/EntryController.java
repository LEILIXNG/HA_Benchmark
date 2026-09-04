package com.habench.cases.java_cmdi_1027_n.web;

import com.habench.cases.java_cmdi_1027_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1027_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1027_n")
    public String handle(
            @RequestParam("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
