package com.habench.shippingadjust.web;

import com.habench.shippingadjust.web.OrderNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingadjustController")
public class ContractController {

    @GetMapping("/api/shipping/adjust")
    public String publish(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        OrderNormalizer.normalize(orderNo);
        return "ok";
    }
}
