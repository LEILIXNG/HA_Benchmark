package com.habench.path1041.web;

import com.habench.path1041.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1041EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1041")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.apply(label);
        return "ok";
    }
}
