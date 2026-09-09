package com.habench.accountdispatch.web;

import com.habench.accountdispatch.web.OrderEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountdispatchController")
public class VoucherController {

    @GetMapping("/api/account/dispatch")
    public String register(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Voucher-Reference");
        OrderEnricher.normalize(orderNo);
        return "ok";
    }
}
