package com.habench.sqli1012n.web;

import com.habench.sqli1012n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1012nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1012_n/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.apply(target);
        return "ok";
    }
}
