package com.habench.ordersettle.web;

import com.habench.ordersettle.web.ChannelTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersettleController")
public class ShipmentController {

    @GetMapping("/api/order/settle")
    public String forward(
            @RequestParam("tag") String tag) {
        ChannelTranslator.translate(tag);
        return "ok";
    }
}
