package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.VoucherRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsubmitController")
public class SessionController {

    @GetMapping("/api/shipping/submit/{reference}")
    public String normalize(
            @PathVariable("reference") String reference) {
        VoucherRouter.route(reference);
        return "ok";
    }
}
