package com.habench.path1040.web;

import com.habench.path1040.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1040EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1040")
    public String handle(
            @RequestParam("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
