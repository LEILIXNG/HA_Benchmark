package com.habench.customerapprove.web;

import com.habench.customerapprove.web.OrderBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerapproveController")
public class OrderController {

    @GetMapping("/api/customer/approve")
    public String forward(HttpServletRequest request) {
        String userName = request.getHeader("X-Order-Client");
        OrderBuilder.compose(userName);
        return "ok";
    }
}
