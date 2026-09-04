package com.habench.accountrefund.web;

import com.habench.accountrefund.web.OrderComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrefundController")
public class OrderController {

    @GetMapping("/api/account/refund")
    public String expand(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        OrderComposer.submit(category);
        return "ok";
    }
}
