package com.habench.cases.java_path_1013_n.web;

import com.habench.cases.java_path_1013_n.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1013_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1013_n")
    public String handle(
            @RequestParam("target") String target) {
        Gateway00.apply(target);
        return "ok";
    }
}
