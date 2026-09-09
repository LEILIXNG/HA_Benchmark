package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.BatchAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryapproveController")
public class ReceiptController {

    @GetMapping("/api/inventory/approve")
    public String stage(
            @RequestHeader("X-Receipt-Trace") String category) {
        BatchAssembler.collect(category);
        return "ok";
    }
}
