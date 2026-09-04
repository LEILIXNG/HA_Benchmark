package com.habench.cases.java_cmdi_1028_n.web;

import com.habench.cases.java_cmdi_1028_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1028_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1028_n/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Gateway00.apply(label);
        return "ok";
    }
}
