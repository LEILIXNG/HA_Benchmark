package com.habench.customerquote.web;

import com.habench.customerquote.web.InvoiceComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerquoteController")
public class AccountController {

    @GetMapping("/api/customer/quote")
    public String route(
            @RequestParam("orderNo") String orderNo) {
        InvoiceComposer.compose(orderNo);
        return "ok";
    }
}
