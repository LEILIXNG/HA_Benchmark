package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.ShipmentAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentadjustController")
public class SessionController {

    @GetMapping("/api/payment/adjust/{filename}")
    public String collect(
            @PathVariable("filename") String filename) {
        ShipmentAdapter.attach(filename);
        return "ok";
    }
}
