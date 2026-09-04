package com.habench.cases.java_cmdi_1041.web;

import com.habench.cases.java_cmdi_1041.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1041EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1041")
    public String handle(
            @RequestParam("target") String target) {
        Gateway00.apply(target);
        return "ok";
    }
}
