package com.habench.cases.java_cmdi_1066_n.web;

import com.habench.cases.java_cmdi_1066_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1066_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1066_n")
    public String handle(
            @RequestParam("userName") String userName) {
        Step00.apply(userName);
        return "ok";
    }
}
