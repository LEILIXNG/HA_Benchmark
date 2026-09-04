package com.habench.sqli1012.web;

import com.habench.sqli1012.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1012EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1012/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.apply(target);
        return "ok";
    }
}
