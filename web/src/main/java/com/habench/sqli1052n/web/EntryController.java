package com.habench.sqli1052n.web;

import com.habench.sqli1052n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1052nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1052_n/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
