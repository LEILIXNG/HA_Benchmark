package com.habench.cases.java_cmdi_1013.web;

import com.habench.cases.java_cmdi_1013.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1013EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1013")
    public String handle(
            @RequestParam("filename") String filename) {
        Step00.apply(filename);
        return "ok";
    }
}
