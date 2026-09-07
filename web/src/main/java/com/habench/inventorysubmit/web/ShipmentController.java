package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.web.InvoiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysubmitController")
public class ShipmentController {

    @GetMapping("/api/inventory/submit/{reference}")
    public String resolve(
            @PathVariable("reference") String reference) {
        InvoiceFacade.refine(reference);
        return "ok";
    }
}
