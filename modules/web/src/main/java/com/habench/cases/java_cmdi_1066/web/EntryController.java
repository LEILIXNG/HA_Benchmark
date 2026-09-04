package com.habench.cases.java_cmdi_1066.web;

import com.habench.cases.java_cmdi_1066.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1066EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1066")
    public String handle(
            @RequestParam("userName") String userName) {
        Step00.apply(userName);
        return "ok";
    }
}
