package com.habench.cmdi1030.web;

import com.habench.cmdi1030.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1030EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1030/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
