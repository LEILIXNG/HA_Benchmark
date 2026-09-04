package com.habench.sqli1061.web;

import com.habench.sqli1061.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1061EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1061/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Stage00.handle(token);
        return "ok";
    }
}
