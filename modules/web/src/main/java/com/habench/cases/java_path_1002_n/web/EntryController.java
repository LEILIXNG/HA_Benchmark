package com.habench.cases.java_path_1002_n.web;

import com.habench.cases.java_path_1002_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1002_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1002_n")
    public String handle(
            @RequestParam("category") String category) {
        Gateway00.apply(category);
        return "ok";
    }
}
