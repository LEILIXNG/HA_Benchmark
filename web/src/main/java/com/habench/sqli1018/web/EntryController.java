package com.habench.sqli1018.web;

import com.habench.sqli1018.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1018EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1018")
    public String handle(
            @RequestParam("target") String target) {
        Stage00.apply(target);
        return "ok";
    }
}
