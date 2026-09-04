package com.habench.sqli1009.web;

import com.habench.sqli1009.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1009EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1009/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
