package com.habench.cases.java_cmdi_1067.web;

import com.habench.cases.java_cmdi_1067.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1067EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1067")
    public String handle(
            @RequestParam("keyword") String keyword) {
        Gateway00.apply(keyword);
        return "ok";
    }
}
