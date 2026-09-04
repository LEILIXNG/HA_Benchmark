package com.habench.cases.java_cmdi_1051_n.web;

import com.habench.cases.java_cmdi_1051_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1051_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1051_n/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Gateway00.apply(tag);
        return "ok";
    }
}
