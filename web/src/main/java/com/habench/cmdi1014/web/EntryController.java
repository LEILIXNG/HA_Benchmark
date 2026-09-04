package com.habench.cmdi1014.web;

import com.habench.cmdi1014.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1014EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1014/{userName}")
    public String handle(
            @PathVariable("userName") String userName) {
        Stage00.handle(userName);
        return "ok";
    }
}
