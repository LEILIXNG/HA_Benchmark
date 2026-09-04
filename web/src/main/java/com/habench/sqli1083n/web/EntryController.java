package com.habench.sqli1083n.web;

import com.habench.sqli1083n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1083nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1083_n/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Stage00.apply(label);
        return "ok";
    }
}
