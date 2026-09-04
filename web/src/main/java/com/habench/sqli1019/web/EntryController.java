package com.habench.sqli1019.web;

import com.habench.sqli1019.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1019EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1019/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Stage00.apply(label);
        return "ok";
    }
}
