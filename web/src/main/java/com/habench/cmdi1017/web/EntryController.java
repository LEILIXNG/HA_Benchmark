package com.habench.cmdi1017.web;

import com.habench.cmdi1017.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1017EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1017/{keyword}")
    public String handle(
            @PathVariable("keyword") String keyword) {
        Stage00.apply(keyword);
        return "ok";
    }
}
