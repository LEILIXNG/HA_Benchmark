package com.habench.sqli1037.web;

import com.habench.sqli1037.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1037EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1037")
    public String handle(
            @RequestParam("query") String query) {
        Stage00.apply(query);
        return "ok";
    }
}
