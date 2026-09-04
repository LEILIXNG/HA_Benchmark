package com.habench.cases.java_sqli_1067.web;

import com.habench.cases.java_sqli_1067.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1067EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1067/{filename}")
    public String handle(
            @PathVariable("filename") String filename) {
        Step00.apply(filename);
        return "ok";
    }
}
