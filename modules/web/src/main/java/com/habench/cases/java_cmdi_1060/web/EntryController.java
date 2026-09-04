package com.habench.cases.java_cmdi_1060.web;

import com.habench.cases.java_cmdi_1060.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1060EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1060")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Step00.apply(orderNo);
        return "ok";
    }
}
