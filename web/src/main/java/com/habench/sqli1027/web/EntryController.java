package com.habench.sqli1027.web;

import com.habench.sqli1027.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1027EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1027")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
