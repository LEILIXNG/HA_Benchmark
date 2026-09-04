package com.habench.sqli1080.web;

import com.habench.sqli1080.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1080EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1080")
    public String handle(
            @RequestParam("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
