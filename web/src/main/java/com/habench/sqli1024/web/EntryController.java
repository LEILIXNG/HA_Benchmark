package com.habench.sqli1024.web;

import com.habench.sqli1024.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1024EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1024/{orderNo}")
    public String handle(
            @PathVariable("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
