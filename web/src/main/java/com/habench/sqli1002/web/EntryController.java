package com.habench.sqli1002.web;

import com.habench.sqli1002.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1002EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1002")
    public String handle(
            @RequestParam("filename") String filename) {
        Stage00.apply(filename);
        return "ok";
    }
}
