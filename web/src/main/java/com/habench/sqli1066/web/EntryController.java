package com.habench.sqli1066.web;

import com.habench.sqli1066.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1066EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1066/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Stage00.apply(keyword);
        return "ok";
    }
}
