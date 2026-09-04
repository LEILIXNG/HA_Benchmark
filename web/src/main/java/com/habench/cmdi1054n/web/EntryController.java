package com.habench.cmdi1054n.web;

import com.habench.cmdi1054n.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cmdi1054nEntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1054_n")
    public String handle(
            @RequestParam("filename") String filename) {
        Stage00.apply(filename);
        return "ok";
    }
}
