package com.habench.ordercapture.web;

import com.habench.ordercapture.web.BatchValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordercaptureController")
public class ChannelController {

    @GetMapping("/api/order/capture/{userName}")
    public String resolve(
            @PathVariable("userName") String userName) {
        BatchValidator.resolve(userName);
        return "ok";
    }
}
