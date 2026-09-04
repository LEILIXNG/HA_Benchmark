package com.habench.cases.java_cmdi_1021.web;

import com.habench.cases.java_cmdi_1021.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_cmdi_1021EntryController")
public class EntryController {

    @GetMapping("/case/java_cmdi_1021/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Step00.apply(orderNo);
        return "ok";
    }
}
