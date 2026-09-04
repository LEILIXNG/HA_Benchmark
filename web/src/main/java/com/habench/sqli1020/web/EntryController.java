package com.habench.sqli1020.web;

import com.habench.sqli1020.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1020EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1020/{category}")
    public String handle(
            @PathVariable("category") String category) {
        Stage00.handle(category);
        return "ok";
    }
}
