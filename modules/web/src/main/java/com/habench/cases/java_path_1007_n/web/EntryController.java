package com.habench.cases.java_path_1007_n.web;

import com.habench.cases.java_path_1007_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_path_1007_nEntryController")
public class EntryController {

    @GetMapping("/case/java_path_1007_n")
    public String handle(
            @RequestParam("query") String query) {
        Step00.apply(query);
        return "ok";
    }
}
