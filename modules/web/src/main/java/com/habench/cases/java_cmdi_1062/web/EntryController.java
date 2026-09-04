package com.habench.cases.java_cmdi_1062.web;

import com.habench.cases.java_cmdi_1062.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1062EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1062/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Step00.apply(keyword);
        return "ok";
    }
}
