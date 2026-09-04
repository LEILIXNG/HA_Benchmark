package com.habench.path1026.web;

import com.habench.path1026.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1026EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1026")
    public String handle(
            @RequestParam("tag") String tag) {
        Stage00.handle(tag);
        return "ok";
    }
}
