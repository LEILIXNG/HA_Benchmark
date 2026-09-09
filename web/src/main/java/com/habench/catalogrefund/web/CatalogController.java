package com.habench.catalogrefund.web;

import com.habench.catalogrefund.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogrefundController")
public class CatalogController {

    @GetMapping("/api/catalog/refund/{userName}")
    public String register(
            @PathVariable("userName") String userName) {
        ReceiptCollector.assemble(userName);
        return "ok";
    }
}
