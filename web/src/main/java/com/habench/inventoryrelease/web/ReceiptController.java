package com.habench.inventoryrelease.web;

import com.habench.inventoryrelease.web.AccountNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreleaseController")
public class ReceiptController {

    @GetMapping("/api/inventory/release")
    public String dispatch(
            @RequestHeader("X-Receipt-Client") String filename) {
        AccountNormalizer.stage(filename);
        return "ok";
    }
}
