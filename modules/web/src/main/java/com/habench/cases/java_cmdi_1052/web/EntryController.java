package com.habench.cases.java_cmdi_1052.web;

import com.habench.cases.java_cmdi_1052.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1052EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1052")
    public String handle(
            @RequestParam("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
