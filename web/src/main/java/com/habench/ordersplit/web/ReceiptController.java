package com.habench.ordersplit.web;

import com.habench.ordersplit.web.BundleBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersplitController")
public class ReceiptController {

    @GetMapping("/api/order/split")
    public String prepare(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        BundleBuilder.enrich(target);
        return "ok";
    }
}
