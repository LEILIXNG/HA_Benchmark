package com.habench.sqli1029.web;

import com.habench.sqli1029.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1029EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1029/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Stage00.apply(tag);
        return "ok";
    }
}
