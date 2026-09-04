package com.habench.cmdi1056n.web;

import com.habench.cmdi1056n.web.Sanitizer00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1056nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1056_n/{filename}")
    public String handle(
            @PathVariable("filename") String filename) {
        Sanitizer00.apply(filename);
        return "ok";
    }
}
