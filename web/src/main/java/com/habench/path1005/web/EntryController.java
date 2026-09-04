package com.habench.path1005.web;

import com.habench.path1005.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1005EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1005")
    public String handle(
            @RequestParam("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
