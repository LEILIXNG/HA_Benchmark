package com.habench.sqli1042.web;

import com.habench.sqli1042.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1042EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1042/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
