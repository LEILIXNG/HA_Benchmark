package com.habench.cases.java_path_1023.web;

import com.habench.cases.java_path_1023.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1023EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1023")
    public String handle(
            @RequestParam("token") String token) {
        Step00.apply(token);
        return "ok";
    }
}
