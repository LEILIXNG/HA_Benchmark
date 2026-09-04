package com.habench.path1019.web;

import com.habench.path1019.web.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1019EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1019")
    public String handle(
            @RequestParam("reference") String reference) {
        Sanitizer00.apply(reference);
        return "ok";
    }
}
