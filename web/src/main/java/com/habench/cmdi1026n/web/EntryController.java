package com.habench.cmdi1026n.web;

import com.habench.cmdi1026n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1026nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1026_n")
    public String handle(
            @RequestParam("resource") String resource) {
        Stage00.apply(resource);
        return "ok";
    }
}
