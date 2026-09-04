package com.habench.cases.java_sqli_1045_n.web;

import com.habench.cases.java_sqli_1045_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1045_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1045_n/{resource}")
    public String handle(
            @PathVariable("resource") String resource) {
        Gateway00.apply(resource);
        return "ok";
    }
}
