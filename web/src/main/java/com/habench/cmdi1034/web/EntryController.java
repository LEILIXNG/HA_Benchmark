package com.habench.cmdi1034.web;

import com.habench.cmdi1034.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1034EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1034")
    public String handle(
            @RequestParam("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
