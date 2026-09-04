package com.habench.customernotice.web;

import com.habench.customernotice.web.OrderNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customernoticeController")
public class RefundController {

    @GetMapping("/api/customer/notice")
    public String assemble(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        OrderNormalizer.enrich(orderNo);
        return "ok";
    }
}
