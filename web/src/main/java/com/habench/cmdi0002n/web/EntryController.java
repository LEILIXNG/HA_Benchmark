package com.habench.cmdi0002n.web;

import com.habench.cmdi0002n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi0002nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_0002_n/{target}")
    public String handle(
            @PathVariable("target") String target) {
        Stage00.handle(target);
        return "ok";
    }
}
