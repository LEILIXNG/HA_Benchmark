package com.habench.customerimport.web;

import com.habench.customerimport.web.ChannelCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerimportController")
public class AccountController {

    @GetMapping("/api/customer/import")
    public String register(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        ChannelCoordinator.normalize(orderNo);
        return "ok";
    }
}
