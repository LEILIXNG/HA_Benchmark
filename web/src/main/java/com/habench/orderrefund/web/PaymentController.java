package com.habench.orderrefund.web;

import com.habench.orderrefund.web.SessionRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderrefundController")
public class PaymentController {

    @GetMapping("/api/order/refund")
    public String dispatch(
            @RequestParam("filename") String filename) {
        SessionRegistry.assemble(filename);
        return "ok";
    }
}
