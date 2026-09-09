package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.BatchRouter;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymenttransferController")
public class InvoiceController {

    @GetMapping("/api/payment/transfer")
    public String submit(
            @CookieValue("invoice_trace") String reference) {
        BatchRouter.submit(reference);
        return "ok";
    }
}
