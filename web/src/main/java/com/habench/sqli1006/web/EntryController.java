package com.habench.sqli1006.web;

import com.habench.sqli1006.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1006EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1006")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.apply(resource);
        return "ok";
    }
}
