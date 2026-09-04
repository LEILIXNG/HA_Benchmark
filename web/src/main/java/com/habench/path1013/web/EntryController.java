package com.habench.path1013.web;

import com.habench.path1013.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1013EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1013")
    public String handle(
            @RequestParam("tag") String tag) {
        Stage00.handle(tag);
        return "ok";
    }
}
