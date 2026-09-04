package com.habench.path1040n.web;

import com.habench.path1040n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1040nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1040_n")
    public String handle(
            @RequestParam("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
