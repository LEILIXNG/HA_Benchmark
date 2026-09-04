package com.habench.cases.java_path_1036.web;

import com.habench.cases.java_path_1036.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1036EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1036")
    public String handle(
            @RequestParam("resource") String resource) {
        Step00.apply(resource);
        return "ok";
    }
}
