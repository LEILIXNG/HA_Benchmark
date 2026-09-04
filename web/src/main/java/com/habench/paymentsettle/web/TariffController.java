package com.habench.paymentsettle.web;

import com.habench.paymentsettle.web.InvoiceBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsettleController")
public class TariffController {

    @GetMapping("/api/payment/settle")
    public String route(
            @RequestParam("label") String label) {
        InvoiceBroker.dispatch(label);
        return "ok";
    }
}
