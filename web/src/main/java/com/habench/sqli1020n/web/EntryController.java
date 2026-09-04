package com.habench.sqli1020n.web;

import com.habench.sqli1020n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1020nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1020_n/{category}")
    public String handle(
            @PathVariable("category") String category) {
        Stage00.handle(category);
        return "ok";
    }
}
