package com.habench.fulfildigest.web;

import com.habench.fulfildigest.web.OrderEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildigestController")
public class VoucherController {

    @GetMapping("/api/fulfil/digest")
    public String register(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        OrderEnricher.normalize(orderNo);
        return "ok";
    }
}
