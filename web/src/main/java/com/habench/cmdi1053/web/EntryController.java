package com.habench.cmdi1053.web;

import com.habench.cmdi1053.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1053EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1053/{filename}")
    public String handle(
            @PathVariable("filename") String filename) {
        Stage00.apply(filename);
        return "ok";
    }
}
