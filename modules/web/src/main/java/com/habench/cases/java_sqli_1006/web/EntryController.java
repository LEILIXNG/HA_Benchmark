package com.habench.cases.java_sqli_1006.web;

import com.habench.cases.java_sqli_1006.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1006EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1006/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Step00.apply(label);
        return "ok";
    }
}
