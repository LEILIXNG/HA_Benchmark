package com.habench.cmdi1049.web;

import com.habench.cmdi1049.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1049EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1049/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
