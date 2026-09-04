package com.habench.cases.java_sqli_1012.web;

import com.habench.cases.java_sqli_1012.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1012EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1012/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Step00.apply(orderNo);
        return "ok";
    }
}
