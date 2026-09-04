package com.habench.sqli1059.web;

import com.habench.sqli1059.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1059EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1059/{reference}")
    public String handle(
            @PathVariable("reference") String reference) {
        Stage00.apply(reference);
        return "ok";
    }
}
