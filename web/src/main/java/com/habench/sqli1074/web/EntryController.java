package com.habench.sqli1074.web;

import com.habench.sqli1074.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1074EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1074")
    public String handle(
            @RequestParam("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
