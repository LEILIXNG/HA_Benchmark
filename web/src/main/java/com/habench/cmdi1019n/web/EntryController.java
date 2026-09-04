package com.habench.cmdi1019n.web;

import com.habench.cmdi1019n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1019nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1019_n/{label}")
    public String handle(
            @PathVariable("label") String label) {
        Stage00.handle(label);
        return "ok";
    }
}
