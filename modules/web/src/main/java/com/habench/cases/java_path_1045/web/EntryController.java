package com.habench.cases.java_path_1045.web;

import com.habench.cases.java_path_1045.web.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1045EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1045")
    public String handle(
            @RequestParam("reference") String reference) {
        Sanitizer00.apply(reference);
        return "ok";
    }
}
