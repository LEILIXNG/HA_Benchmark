package com.habench.sqli1082.web;

import com.habench.sqli1082.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1082EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1082/{filename}")
    public String handle(
            @PathVariable("filename") String filename) {
        Stage00.apply(filename);
        return "ok";
    }
}
