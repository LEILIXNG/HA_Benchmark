package com.habench.sqli1008.web;

import com.habench.sqli1008.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1008EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1008/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
