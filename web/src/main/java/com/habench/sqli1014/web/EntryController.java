package com.habench.sqli1014.web;

import com.habench.sqli1014.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1014EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1014/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
