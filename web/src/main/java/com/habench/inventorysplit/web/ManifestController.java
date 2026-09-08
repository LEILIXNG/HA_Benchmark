package com.habench.inventorysplit.web;

import com.habench.inventorysplit.web.RefundAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysplitController")
public class ManifestController {

    @GetMapping("/api/inventory/split")
    public String register(
            @RequestParam("orderNo") String orderNo) {
        RefundAssembler.expand(orderNo);
        return "ok";
    }
}
