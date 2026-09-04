package com.habench.ordersplit.web;

import com.habench.ordersplit.web.ChannelNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersplitController")
public class ReceiptController {

    @GetMapping("/api/order/split")
    public String enrich(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        ChannelNormalizer.attach(userName);
        return "ok";
    }
}
