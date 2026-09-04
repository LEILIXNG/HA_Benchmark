package com.habench.sqli1038n.web;

import com.habench.sqli1038n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1038nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1038_n")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
