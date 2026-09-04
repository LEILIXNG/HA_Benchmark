package com.habench.cases.java_path_1032.web;

import com.habench.cases.java_path_1032.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1032EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1032")
    public String handle(
            @RequestParam("tag") String tag) {
        Step00.apply(tag);
        return "ok";
    }
}
