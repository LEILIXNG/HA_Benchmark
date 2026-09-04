package com.habench.cases.java_path_1034.web;

import com.habench.cases.java_path_1034.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1034EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1034")
    public String handle(
            @RequestParam("target") String target) {
        Step00.apply(target);
        return "ok";
    }
}
