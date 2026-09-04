package com.habench.cmdi1056.web;

import com.habench.cmdi1056.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1056EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1056/{filename}")
    public String handle(
            @PathVariable("filename") String filename) {
        Stage00.handle(filename);
        return "ok";
    }
}
