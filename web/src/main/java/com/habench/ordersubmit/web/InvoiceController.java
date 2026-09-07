package com.habench.ordersubmit.web;

import com.habench.ordersubmit.web.ContractCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersubmitController")
public class InvoiceController {

    @GetMapping("/api/order/submit")
    public String merge(
            @RequestParam("resource") String resource) {
        ContractCoordinator.dispatch(resource);
        return "ok";
    }
}
