package com.habench.cmdi1028.web;

import com.habench.cmdi1028.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1028EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1028/{query}")
    public String handle(
            @PathVariable("query") String query) {
        Stage00.handle(query);
        return "ok";
    }
}
