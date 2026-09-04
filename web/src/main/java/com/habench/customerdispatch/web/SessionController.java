package com.habench.customerdispatch.web;

import com.habench.customerdispatch.web.VoucherCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdispatchController")
public class SessionController {

    @GetMapping("/api/customer/dispatch")
    public String resolve(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        VoucherCoordinator.prepare(orderNo);
        return "ok";
    }
}
