package com.habench.path1003n.web;

import com.habench.path1003n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1003nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1003_n")
    public String handle(
            @RequestParam("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
