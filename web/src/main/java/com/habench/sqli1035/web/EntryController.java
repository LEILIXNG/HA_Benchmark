package com.habench.sqli1035.web;

import com.habench.sqli1035.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1035EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1035")
    public String handle(
            @RequestParam("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
