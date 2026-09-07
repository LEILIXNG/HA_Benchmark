package com.habench.inventoryreview.web;

import com.habench.inventoryreview.web.BundleFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreviewController")
public class ContractController {

    @GetMapping("/api/inventory/review")
    public String merge(
            @RequestParam("keyword") String keyword) {
        BundleFacade.compose(keyword);
        return "ok";
    }
}
