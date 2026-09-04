package com.habench.sqli1043.web;

import com.habench.sqli1043.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1043EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1043")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
