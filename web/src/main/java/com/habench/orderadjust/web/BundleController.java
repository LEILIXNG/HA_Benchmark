package com.habench.orderadjust.web;

import com.habench.orderadjust.web.BatchBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderadjustController")
public class BundleController {

    @GetMapping("/api/order/adjust")
    public String resolve(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        BatchBroker.collect(keyword);
        return "ok";
    }
}
