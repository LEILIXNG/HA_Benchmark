package com.habench.sqli1004.web;

import com.habench.sqli1004.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1004EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1004/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Stage00.apply(token);
        return "ok";
    }
}
