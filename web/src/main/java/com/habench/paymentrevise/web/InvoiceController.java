package com.habench.paymentrevise.web;

import com.habench.paymentrevise.web.ShipmentAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreviseController")
public class InvoiceController {

    @GetMapping("/api/payment/revise")
    public String assemble(
            @RequestParam("filename") String filename) {
        ShipmentAdapter.stage(filename);
        return "ok";
    }
}
