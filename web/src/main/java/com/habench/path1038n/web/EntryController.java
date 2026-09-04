package com.habench.path1038n.web;

import com.habench.path1038n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1038nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1038_n")
    public String handle(
            @RequestParam("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
