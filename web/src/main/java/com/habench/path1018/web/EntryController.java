package com.habench.path1018.web;

import com.habench.path1018.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1018EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1018")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.handle(resource);
        return "ok";
    }
}
