package com.habench.sqli1044.web;

import com.habench.sqli1044.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1044EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1044")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
