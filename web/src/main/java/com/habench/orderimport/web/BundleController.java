package com.habench.orderimport.web;

import com.habench.orderimport.web.TariffBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderimportController")
public class BundleController {

    @GetMapping("/api/order/import/{orderNo}")
    public String collect(
            @PathVariable("orderNo") String orderNo) {
        TariffBroker.collect(orderNo);
        return "ok";
    }
}
