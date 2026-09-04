package com.habench.cases.java_cmdi_1026.web;

import com.habench.cases.java_cmdi_1026.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1026EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1026")
    public String handle(
            @RequestParam("tag") String tag) {
        Gateway00.apply(tag);
        return "ok";
    }
}
