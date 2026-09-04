package com.habench.sqli1081.web;

import com.habench.sqli1081.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1081EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1081")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.handle(resource);
        return "ok";
    }
}
