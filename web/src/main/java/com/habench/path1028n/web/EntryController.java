package com.habench.path1028n.web;

import com.habench.path1028n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("path1028nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1028_n")
    public String handle(
            @RequestParam("token") String token) {
        Stage00.apply(token);
        return "ok";
    }
}
