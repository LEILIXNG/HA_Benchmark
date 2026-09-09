package com.habench.vendorreconcile.web;

import com.habench.vendorreconcile.web.ChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreconcileController")
public class TariffController {

    @GetMapping("/api/vendor/reconcile")
    public String attach(
            @RequestParam("orderNo") String orderNo) {
        ChannelBuilder.publish(orderNo);
        return "ok";
    }
}
