package com.habench.catalogrevise.web;

import com.habench.catalogrevise.web.RefundRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreviseController")
public class InvoiceController {

    @GetMapping("/api/catalog/revise")
    public String prepare(
            @RequestParam("category") String category) {
        RefundRegistry.publish(category);
        return "ok";
    }
}
