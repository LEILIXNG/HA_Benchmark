package com.habench.ordermerge.web;

import com.habench.ordermerge.web.BundleBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordermergeController")
public class TariffController {

    @GetMapping("/api/order/merge")
    public String route(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        BundleBuilder.submit(orderNo);
        return "ok";
    }
}
