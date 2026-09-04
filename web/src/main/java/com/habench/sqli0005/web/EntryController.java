package com.habench.sqli0005.web;

import com.habench.sqli0005.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli0005EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_0005")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
