package com.habench.sqli0001.web;

import com.habench.sqli0001.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli0001EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_0001")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
