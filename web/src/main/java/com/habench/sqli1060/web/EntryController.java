package com.habench.sqli1060.web;

import com.habench.sqli1060.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1060EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1060")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.apply(resource);
        return "ok";
    }
}
