package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.web.BatchCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingtransferController")
public class SessionController {

    @GetMapping("/api/pricing/transfer/{userName}")
    public String expand(
            @PathVariable("userName") String userName) {
        BatchCollector.forward(userName);
        return "ok";
    }
}
