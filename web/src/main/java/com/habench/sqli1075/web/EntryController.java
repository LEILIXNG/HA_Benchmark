package com.habench.sqli1075.web;

import com.habench.sqli1075.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1075EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1075")
    public String handle(
            @RequestParam("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
