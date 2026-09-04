package com.habench.sqli1053.web;

import com.habench.sqli1053.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1053EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1053")
    public String handle(
            @RequestParam("reference") String reference) {
        Stage00.apply(reference);
        return "ok";
    }
}
