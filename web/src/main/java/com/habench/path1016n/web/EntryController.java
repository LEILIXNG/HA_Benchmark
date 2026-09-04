package com.habench.path1016n.web;

import com.habench.path1016n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1016nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1016_n")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.apply(label);
        return "ok";
    }
}
