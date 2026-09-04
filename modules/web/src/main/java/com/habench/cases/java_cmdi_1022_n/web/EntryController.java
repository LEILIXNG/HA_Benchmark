package com.habench.cases.java_cmdi_1022_n.web;

import com.habench.cases.java_cmdi_1022_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1022_nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1022_n")
    public String handle(
            @RequestParam("filename") String filename) {
        Step00.apply(filename);
        return "ok";
    }
}
