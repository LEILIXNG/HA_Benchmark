package com.habench.cmdi1023.web;

import com.habench.cmdi1023.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1023EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1023")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.handle(keyword);
        return "ok";
    }
}
