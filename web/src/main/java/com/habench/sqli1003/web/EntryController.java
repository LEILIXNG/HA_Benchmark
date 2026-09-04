package com.habench.sqli1003.web;

import com.habench.sqli1003.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1003EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1003/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
