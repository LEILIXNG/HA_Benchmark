package com.habench.billingapprove.web;

import com.habench.billingapprove.web.VoucherFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingapproveController")
public class OrderController {

    @GetMapping("/api/billing/approve")
    public String publish(
            @RequestParam("userName") String userName) {
        VoucherFacade.attach(userName);
        return "ok";
    }
}
