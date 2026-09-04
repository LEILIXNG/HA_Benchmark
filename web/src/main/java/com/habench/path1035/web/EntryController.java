package com.habench.path1035.web;

import com.habench.path1035.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1035EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1035")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.handle(resource);
        return "ok";
    }
}
