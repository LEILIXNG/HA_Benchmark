package com.habench.cmdi1002.web;

import com.habench.cmdi1002.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1002EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1002")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
