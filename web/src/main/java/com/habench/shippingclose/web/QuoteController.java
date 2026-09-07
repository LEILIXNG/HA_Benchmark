package com.habench.shippingclose.web;

import com.habench.shippingclose.web.VoucherRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingcloseController")
public class QuoteController {

    @GetMapping("/api/shipping/close/{filename}")
    public String route(
            @PathVariable("filename") String filename) {
        VoucherRouter.forward(filename);
        return "ok";
    }
}
