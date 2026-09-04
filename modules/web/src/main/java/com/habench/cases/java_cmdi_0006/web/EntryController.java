package com.habench.cases.java_cmdi_0006.web;

import com.habench.cases.java_cmdi_0006.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_0006EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_0006")
    public String handle(
            @RequestParam("cmd") String cmd) {
        Step00.apply(cmd);
        return "ok";
    }
}
