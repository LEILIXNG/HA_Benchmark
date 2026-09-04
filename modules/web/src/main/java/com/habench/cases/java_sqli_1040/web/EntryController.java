package com.habench.cases.java_sqli_1040.web;

import com.habench.cases.java_sqli_1040.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1040EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1040/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Step00.apply(orderNo);
        return "ok";
    }
}
