package com.habench.cases.java_cmdi_1068.web;

import com.habench.cases.java_cmdi_1068.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1068EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1068")
    public String handle(
            @RequestParam("label") String label) {
        Gateway00.apply(label);
        return "ok";
    }
}
