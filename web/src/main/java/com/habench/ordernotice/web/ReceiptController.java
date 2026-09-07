package com.habench.ordernotice.web;

import com.habench.ordernotice.web.ChannelCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordernoticeController")
public class ReceiptController {

    @GetMapping("/api/order/notice")
    public String attach(
            @RequestParam("userName") String userName) {
        ChannelCollector.refine(userName);
        return "ok";
    }
}
