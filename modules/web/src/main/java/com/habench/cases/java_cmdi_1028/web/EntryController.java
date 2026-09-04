package com.habench.cases.java_cmdi_1028.web;

import com.habench.cases.java_cmdi_1028.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1028EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1028/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Gateway00.apply(label);
        return "ok";
    }
}
