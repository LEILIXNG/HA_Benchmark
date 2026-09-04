package com.habench.cases.java_sqli_1018.web;

import com.habench.cases.java_sqli_1018.service.Gateway00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("java_sqli_1018EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1018/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Gateway00.apply(orderNo);
        return "ok";
    }
}
