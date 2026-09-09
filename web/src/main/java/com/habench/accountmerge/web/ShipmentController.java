package com.habench.accountmerge.web;

import com.habench.accountmerge.web.InvoiceNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountmergeController")
public class ShipmentController {

    @GetMapping("/api/account/merge")
    public String compose(
            @RequestParam("query") String query) {
        InvoiceNormalizer.dispatch(query);
        return "ok";
    }
}
