package com.habench.accountarchive.web;

import com.habench.accountarchive.web.RefundBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountarchiveController")
public class SessionController {

    @GetMapping("/api/account/archive")
    public String attach(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        RefundBroker.route(orderNo);
        return "ok";
    }
}
