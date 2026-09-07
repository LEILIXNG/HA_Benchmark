package com.habench.shippingadjust.web;

import com.habench.shippingadjust.web.VoucherFilter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingadjustController")
public class ReceiptController {

    @GetMapping("/api/shipping/adjust")
    public String stage(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        VoucherFilter.normalize(query);
        return "ok";
    }
}
