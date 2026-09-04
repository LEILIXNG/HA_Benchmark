package com.habench.cases.java_cmdi_1023.web;

import com.habench.cases.java_cmdi_1023.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1023EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1023")
    public String handle(
            @RequestParam("reference") String reference) {
        Gateway00.apply(reference);
        return "ok";
    }
}
