package com.habench.cmdi1022n.web;

import com.habench.cmdi1022n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1022nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1022_n")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.handle(resource);
        return "ok";
    }
}
