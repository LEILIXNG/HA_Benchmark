package com.habench.sqli1021.web;

import com.habench.sqli1021.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1021EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1021/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Stage00.apply(keyword);
        return "ok";
    }
}
