package com.habench.customertransfer.web;

import com.habench.customertransfer.web.VoucherRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customertransferController")
public class AccountController {

    @GetMapping("/api/customer/transfer")
    public String attach(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        VoucherRegistry.forward(orderNo);
        return "ok";
    }
}
