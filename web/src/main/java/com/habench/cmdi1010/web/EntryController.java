package com.habench.cmdi1010.web;

import com.habench.cmdi1010.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1010EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1010")
    public String handle(
            @RequestParam("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
