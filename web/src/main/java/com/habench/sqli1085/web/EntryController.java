package com.habench.sqli1085.web;

import com.habench.sqli1085.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1085EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1085")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.apply(label);
        return "ok";
    }
}
