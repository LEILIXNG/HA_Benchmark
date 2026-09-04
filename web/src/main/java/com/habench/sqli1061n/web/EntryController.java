package com.habench.sqli1061n.web;

import com.habench.sqli1061n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1061nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1061_n/{token}")
    public String handle(
            @PathVariable("token") String token) {
        Stage00.handle(token);
        return "ok";
    }
}
