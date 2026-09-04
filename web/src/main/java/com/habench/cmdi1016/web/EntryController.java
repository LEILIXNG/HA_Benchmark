package com.habench.cmdi1016.web;

import com.habench.cmdi1016.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1016EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1016")
    public String handle(
            @RequestParam("category") String category) {
        Stage00.handle(category);
        return "ok";
    }
}
