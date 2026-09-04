package com.habench.sqli1015.web;

import com.habench.sqli1015.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1015EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1015/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Stage00.apply(tag);
        return "ok";
    }
}
