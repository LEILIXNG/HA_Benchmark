package com.habench.cases.java_path_1020.web;

import com.habench.cases.java_path_1020.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1020EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1020")
    public String handle(
            @RequestParam("query") String query) {
        Gateway00.apply(query);
        return "ok";
    }
}
