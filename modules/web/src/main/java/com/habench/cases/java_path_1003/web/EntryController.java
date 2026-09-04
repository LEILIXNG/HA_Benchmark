package com.habench.cases.java_path_1003.web;

import com.habench.cases.java_path_1003.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1003EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1003")
    public String handle(
            @RequestParam("category") String category) {
        Step00.apply(category);
        return "ok";
    }
}
