package com.habench.cases.java_cmdi_1062_n.web;

import com.habench.cases.java_cmdi_1062_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1062_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1062_n/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Step00.apply(keyword);
        return "ok";
    }
}
