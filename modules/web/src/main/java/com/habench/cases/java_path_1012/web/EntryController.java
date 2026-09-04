package com.habench.cases.java_path_1012.web;

import com.habench.cases.java_path_1012.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1012EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1012")
    public String handle(
            @RequestParam("reference") String reference) {
        Gateway00.apply(reference);
        return "ok";
    }
}
