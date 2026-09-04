package com.habench.sqli1058.web;

import com.habench.sqli1058.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1058EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1058/{reference}")
    public String handle(
            @PathVariable("reference") String reference) {
        Stage00.handle(reference);
        return "ok";
    }
}
