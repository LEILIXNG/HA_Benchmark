package com.habench.fulfilmerge.web;

import com.habench.fulfilmerge.web.ReceiptBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilmergeController")
public class InvoiceController {

    @GetMapping("/api/fulfil/merge")
    public String attach(
            @RequestParam("category") String category) {
        ReceiptBuilder.resolve(category);
        return "ok";
    }
}
