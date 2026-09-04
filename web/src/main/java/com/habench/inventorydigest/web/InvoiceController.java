package com.habench.inventorydigest.web;

import com.habench.inventorydigest.web.SessionEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydigestController")
public class InvoiceController {

    @GetMapping("/api/inventory/digest/{filename}")
    public String normalize(
            @PathVariable("filename") String filename) {
        SessionEnricher.stage(filename);
        return "ok";
    }
}
