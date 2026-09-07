package com.habench.inventorycapture.web;

import com.habench.inventorycapture.web.InvoiceResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorycaptureController")
public class ChannelController {

    @GetMapping("/api/inventory/capture/{orderNo}")
    public String expand(
            @PathVariable("orderNo") String orderNo) {
        InvoiceResolver.forward(orderNo);
        return "ok";
    }
}
