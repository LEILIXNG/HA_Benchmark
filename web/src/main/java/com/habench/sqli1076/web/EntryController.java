package com.habench.sqli1076.web;

import com.habench.sqli1076.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1076EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1076/{reference}")
    public String handle(
            @PathVariable("reference") String reference) {
        Stage00.handle(reference);
        return "ok";
    }
}
