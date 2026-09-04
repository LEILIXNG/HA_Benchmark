package com.habench.sqli0004.web;

import com.habench.sqli0004.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli0004EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_0004")
    public String handle(
            @RequestParam("q") String q) {
        Stage00.handle(q);
        return "ok";
    }
}
