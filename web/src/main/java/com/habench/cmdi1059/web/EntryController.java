package com.habench.cmdi1059.web;

import com.habench.cmdi1059.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1059EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1059/{resource}")
    public String handle(
            @PathVariable("resource") String resource) {
        Stage00.handle(resource);
        return "ok";
    }
}
