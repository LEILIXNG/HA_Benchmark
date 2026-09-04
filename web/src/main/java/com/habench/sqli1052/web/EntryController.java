package com.habench.sqli1052.web;

import com.habench.sqli1052.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1052EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1052/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
