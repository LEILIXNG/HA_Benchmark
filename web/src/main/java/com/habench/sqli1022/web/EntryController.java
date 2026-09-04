package com.habench.sqli1022.web;

import com.habench.sqli1022.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1022EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1022")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.apply(keyword);
        return "ok";
    }
}
