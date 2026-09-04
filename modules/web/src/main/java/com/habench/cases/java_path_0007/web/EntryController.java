package com.habench.cases.java_path_0007.web;

import com.habench.cases.java_path_0007.web.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_0007EntryController")
public class EntryController {

    @GetMapping("/case/java_path_0007")
    public String handle(
            @RequestParam("file") String file) {
        Sanitizer00.apply(file);
        return "ok";
    }
}
