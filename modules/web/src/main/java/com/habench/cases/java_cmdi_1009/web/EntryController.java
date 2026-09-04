package com.habench.cases.java_cmdi_1009.web;

import com.habench.cases.java_cmdi_1009.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1009EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1009")
    public String handle(
            @RequestParam("tag") String tag) {
        Step00.apply(tag);
        return "ok";
    }
}
