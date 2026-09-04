package com.habench.sqli1040.web;

import com.habench.sqli1040.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1040EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1040/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
