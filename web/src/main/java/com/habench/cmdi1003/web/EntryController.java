package com.habench.cmdi1003.web;

import com.habench.cmdi1003.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1003EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1003/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
