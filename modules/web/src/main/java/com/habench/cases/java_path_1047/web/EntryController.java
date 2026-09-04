package com.habench.cases.java_path_1047.web;

import com.habench.cases.java_path_1047.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1047EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1047")
    public String handle(
            @RequestParam("target") String target) {
        Gateway00.apply(target);
        return "ok";
    }
}
