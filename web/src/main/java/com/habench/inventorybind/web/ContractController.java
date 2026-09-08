package com.habench.inventorybind.web;

import com.habench.inventorybind.web.QuoteComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorybindController")
public class ContractController {

    @GetMapping("/api/inventory/bind")
    public String translate(
            @RequestParam("orderNo") String orderNo) {
        QuoteComposer.merge(orderNo);
        return "ok";
    }
}
