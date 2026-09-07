package com.habench.catalogreopen.web;

import com.habench.catalogreopen.web.ReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreopenController")
public class OrderController {

    @GetMapping("/api/catalog/reopen/{category}")
    public String merge(
            @PathVariable("category") String category) {
        ReceiptService.translate(category);
        return "ok";
    }
}
