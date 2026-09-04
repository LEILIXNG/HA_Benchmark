package com.habench.sqli1032.web;

import com.habench.sqli1032.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1032EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1032")
    public String handle(
            @RequestParam("token") String token) {
        Stage00.handle(token);
        return "ok";
    }
}
