package com.habench.customerrefund.web;

import com.habench.customerrefund.web.RefundAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrefundController")
public class TariffController {

    @GetMapping("/api/customer/refund")
    public String dispatch(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        RefundAdapter.stage(orderNo);
        return "ok";
    }
}
