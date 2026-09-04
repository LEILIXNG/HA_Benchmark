package com.habench.sqli1034.web;

import com.habench.sqli1034.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1034EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1034")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
