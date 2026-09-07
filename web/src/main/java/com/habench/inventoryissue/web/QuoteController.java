package com.habench.inventoryissue.web;

import com.habench.inventoryissue.web.VoucherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryissueController")
public class QuoteController {

    @GetMapping("/api/inventory/issue/{resource}")
    public String prepare(
            @PathVariable("resource") String resource) {
        VoucherService.collect(resource);
        return "ok";
    }
}
