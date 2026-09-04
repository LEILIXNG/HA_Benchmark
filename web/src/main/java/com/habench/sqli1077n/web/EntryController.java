package com.habench.sqli1077n.web;

import com.habench.sqli1077n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1077nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1077_n/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
