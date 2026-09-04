package com.habench.cmdi1012.web;

import com.habench.cmdi1012.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1012EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1012")
    public String handle(
            @RequestParam("userName") String userName) {
        Stage00.apply(userName);
        return "ok";
    }
}
