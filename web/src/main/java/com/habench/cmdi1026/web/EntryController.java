package com.habench.cmdi1026.web;

import com.habench.cmdi1026.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1026EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1026")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.apply(resource);
        return "ok";
    }
}
