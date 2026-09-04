package com.habench.sqli1010.web;

import com.habench.sqli1010.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1010EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1010/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
