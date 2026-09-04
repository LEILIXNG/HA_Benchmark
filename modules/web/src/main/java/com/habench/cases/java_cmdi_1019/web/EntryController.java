package com.habench.cases.java_cmdi_1019.web;

import com.habench.cases.java_cmdi_1019.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1019EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1019/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Step00.apply(userName);
        return "ok";
    }
}
