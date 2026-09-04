package com.habench.cases.java_sqli_1012_n.web;

import com.habench.cases.java_sqli_1012_n.web.Step00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1012_nEntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1012_n/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Step00.apply(orderNo);
        return "ok";
    }
}
