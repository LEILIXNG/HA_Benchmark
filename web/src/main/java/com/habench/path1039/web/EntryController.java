package com.habench.path1039.web;

import com.habench.path1039.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1039EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1039")
    public String handle(
            @RequestParam("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
