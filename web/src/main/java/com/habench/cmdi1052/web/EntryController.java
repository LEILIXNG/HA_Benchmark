package com.habench.cmdi1052.web;

import com.habench.cmdi1052.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1052EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1052/{tag}")
    public String handle(
            @PathVariable("tag") String tag) {
        Stage00.handle(tag);
        return "ok";
    }
}
