package com.habench.path1050.web;

import com.habench.path1050.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1050EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1050")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
