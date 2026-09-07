package com.habench.orderrevise.web;

import com.habench.orderrevise.web.InvoiceCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviseController")
public class BundleController {

    @GetMapping("/api/order/revise/{userName}")
    public String resolve(
            @PathVariable("userName") String userName) {
        InvoiceCollector.translate(userName);
        return "ok";
    }
}
