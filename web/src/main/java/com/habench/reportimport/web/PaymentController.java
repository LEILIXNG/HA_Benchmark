package com.habench.reportimport.web;

import com.habench.reportimport.web.InvoiceAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportimportController")
public class PaymentController {

    @GetMapping("/api/report/import/{userName}")
    public String attach(
            @PathVariable("userName") String userName) {
        InvoiceAdapter.stage(userName);
        return "ok";
    }
}
