package com.habench.sqli1036.web;

import com.habench.sqli1036.web.Stage00;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sqli1036EntryController")
public class EntryController {

    @GetMapping("/case/java_sqli_1036")
    public String handle(
            @RequestParam("orderNo") String orderNo) {
        Stage00.handle(orderNo);
        return "ok";
    }
}
