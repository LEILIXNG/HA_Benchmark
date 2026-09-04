package com.habench.cmdi1043.web;

import com.habench.cmdi1043.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1043EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1043/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
