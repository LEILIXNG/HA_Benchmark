package com.habench.sqli1011.web;

import com.habench.sqli1011.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1011EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1011/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.apply(userName);
        return "ok";
    }
}
