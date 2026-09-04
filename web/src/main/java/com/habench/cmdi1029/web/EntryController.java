package com.habench.cmdi1029.web;

import com.habench.cmdi1029.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1029EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1029/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
