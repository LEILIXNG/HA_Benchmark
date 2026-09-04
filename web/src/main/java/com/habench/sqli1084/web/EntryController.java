package com.habench.sqli1084.web;

import com.habench.sqli1084.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1084EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1084")
    public String handle(
            @RequestParam("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
