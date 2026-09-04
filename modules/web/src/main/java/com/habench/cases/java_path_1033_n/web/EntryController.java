package com.habench.cases.java_path_1033_n.web;

import com.habench.cases.java_path_1033_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1033_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1033_n")
    public String handle(
            @RequestParam("reference") String reference) {
        Step00.apply(reference);
        return "ok";
    }
}
