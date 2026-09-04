package com.habench.sqli1057.web;

import com.habench.sqli1057.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1057EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1057")
    public String handle(
            @RequestParam("tag") String tag) {
        Stage00.handle(tag);
        return "ok";
    }
}
