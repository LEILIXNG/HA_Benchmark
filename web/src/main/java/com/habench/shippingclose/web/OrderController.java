package com.habench.shippingclose.web;

import com.habench.shippingclose.web.VoucherRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingcloseController")
public class OrderController {

    @GetMapping("/api/shipping/close/{tag}")
    public String stage(
            @PathVariable("tag") String tag) {
        VoucherRouter.forward(tag);
        return "ok";
    }
}
