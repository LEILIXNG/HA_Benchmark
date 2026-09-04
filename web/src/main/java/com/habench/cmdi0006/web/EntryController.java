package com.habench.cmdi0006.web;

import com.habench.cmdi0006.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi0006EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_0006")
    public String handle(
            @RequestParam("cmd") String cmd) {
        Stage00.handle(cmd);
        return "ok";
    }
}
