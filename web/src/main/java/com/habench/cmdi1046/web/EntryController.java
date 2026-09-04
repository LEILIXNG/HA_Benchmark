package com.habench.cmdi1046.web;

import com.habench.cmdi1046.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1046EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1046")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Stage00.apply(keyword);
        return "ok";
    }
}
