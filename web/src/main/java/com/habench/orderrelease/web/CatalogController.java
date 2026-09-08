package com.habench.orderrelease.web;

import com.habench.orderrelease.web.ChannelAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreleaseController")
public class CatalogController {

    @GetMapping("/api/order/release")
    public String dispatch(
            @RequestParam("resource") String resource) {
        ChannelAdapter.reconcile(resource);
        return "ok";
    }
}
