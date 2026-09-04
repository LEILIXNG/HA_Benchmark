package com.habench.sqli1000.web;

import com.habench.sqli1000.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1000EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1000/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Stage00.handle(tag);
        return "ok";
    }
}
