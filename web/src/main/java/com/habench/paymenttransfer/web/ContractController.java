package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.InvoiceResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymenttransferController")
public class ContractController {

    @GetMapping("/api/payment/transfer/{filename}")
    public String stage(
            @PathVariable("filename") String filename) {
        InvoiceResolver.stage(filename);
        return "ok";
    }
}
