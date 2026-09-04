package com.habench.customerbatch.web;

import com.habench.customerbatch.web.RefundCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerbatchController")
public class BatchController {

    @GetMapping("/api/customer/batch")
    public String collect(
            @RequestParam("userName") String userName) {
        RefundCollector.assemble(userName);
        return "ok";
    }
}
