package com.habench.sqli1085n.web;

import com.habench.sqli1085n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1085nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1085_n")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.apply(label);
        return "ok";
    }
}
