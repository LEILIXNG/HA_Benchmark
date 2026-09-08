package com.habench.orderapprove.web;

import com.habench.orderapprove.web.BundleFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderapproveController")
public class RefundController {

    @GetMapping("/api/order/approve/{query}")
    public String prepare(
            @PathVariable("query") String query) {
        BundleFacade.reconcile(query);
        return "ok";
    }
}
