package com.habench.sqli1042n.web;

import com.habench.sqli1042n.web.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1042nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1042_n/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Sanitizer00.apply(userName);
        return "ok";
    }
}
