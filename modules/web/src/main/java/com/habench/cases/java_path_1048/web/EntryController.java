package com.habench.cases.java_path_1048.web;

import com.habench.cases.java_path_1048.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1048EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1048")
    public String handle(
            @RequestParam("filename") String filename) {
        Step00.apply(filename);
        return "ok";
    }
}
