package com.habench.inventoryrefund.web;

import com.habench.inventoryrefund.web.TariffFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrefundController")
public class InvoiceController {

    @GetMapping("/api/inventory/refund")
    public String forward(
            @RequestParam("tag") String tag) {
        TariffFacade.register(tag);
        return "ok";
    }
}
