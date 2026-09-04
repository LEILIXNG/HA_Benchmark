package com.habench.sqli1040n.web;

import com.habench.sqli1040n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1040nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1040_n/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
