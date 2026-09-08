package com.habench.ordersettlequeue.web;

import com.habench.ordersettlequeue.web.ReceiptComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersettlequeueController")
public class RefundController {

    @GetMapping("/api/order/settlequeue")
    public String compose(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ReceiptComposer.publish(category);
        return "ok";
    }
}
