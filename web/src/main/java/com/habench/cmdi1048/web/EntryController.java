package com.habench.cmdi1048.web;

import com.habench.cmdi1048.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1048EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1048")
    public String handle(
            @RequestParam("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
