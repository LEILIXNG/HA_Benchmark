package com.habench.cases.java_sqli_1008.web;

import com.habench.cases.java_sqli_1008.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1008EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1008/{filename}")
    public String handle(
            @PathVariable("filename") String filename) {
        Gateway00.apply(filename);
        return "ok";
    }
}
