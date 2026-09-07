package com.habench.ordertransfer.web;

import com.habench.ordertransfer.web.InvoiceNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordertransferController")
public class ShipmentController {

    @GetMapping("/api/order/transfer")
    public String compose(
            @RequestParam("query") String query) {
        InvoiceNormalizer.dispatch(query);
        return "ok";
    }
}
