package com.habench.shippingclose.web;

import com.habench.shippingclose.web.InvoiceRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingcloseController")
public class OrderController {

    @GetMapping("/api/shipping/close/{label}")
    public String assemble(
            @PathVariable("label") String label) {
        InvoiceRouter.attach(label);
        return "ok";
    }
}
