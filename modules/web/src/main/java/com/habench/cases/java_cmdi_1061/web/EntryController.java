package com.habench.cases.java_cmdi_1061.web;

import com.habench.cases.java_cmdi_1061.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1061EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1061")
    public String handle(
            @RequestParam("label") String label) {
        Gateway00.apply(label);
        return "ok";
    }
}
