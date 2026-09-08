package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.web.ChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiltransferController")
public class TariffController {

    @GetMapping("/api/fulfil/transfer")
    public String attach(
            @RequestParam("orderNo") String orderNo) {
        ChannelBuilder.publish(orderNo);
        return "ok";
    }
}
