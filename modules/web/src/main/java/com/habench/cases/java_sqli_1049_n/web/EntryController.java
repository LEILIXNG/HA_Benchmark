package com.habench.cases.java_sqli_1049_n.web;

import com.habench.cases.java_sqli_1049_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1049_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1049_n/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Gateway00.apply(userName);
        return "ok";
    }
}
