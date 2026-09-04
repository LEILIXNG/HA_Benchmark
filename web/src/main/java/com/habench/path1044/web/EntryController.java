package com.habench.path1044.web;

import com.habench.path1044.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1044EntryController")
public class EntryController {

    @GetMapping("/case/java_path_1044")
    public String handle(
            @RequestParam("token") String token) {
        Stage00.apply(token);
        return "ok";
    }
}
