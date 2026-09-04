package com.habench.cases.java_cmdi_1058_n.web;

import com.habench.cases.java_cmdi_1058_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1058_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1058_n/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Step00.apply(token);
        return "ok";
    }
}
