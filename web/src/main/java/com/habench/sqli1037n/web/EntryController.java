package com.habench.sqli1037n.web;

import com.habench.sqli1037n.web.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1037nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1037_n")
    public String handle(
            @RequestParam("query") String query) {
        Sanitizer00.apply(query);
        return "ok";
    }
}
