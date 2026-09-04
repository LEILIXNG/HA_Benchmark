package com.habench.sqli1078.web;

import com.habench.sqli1078.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1078EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1078/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
