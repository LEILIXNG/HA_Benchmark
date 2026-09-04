package com.habench.cases.java_path_1031.web;

import com.habench.cases.java_path_1031.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1031EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1031")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Step00.apply(keyword);
        return "ok";
    }
}
