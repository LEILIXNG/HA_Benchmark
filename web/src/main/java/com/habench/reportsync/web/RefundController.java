package com.habench.reportsync.web;

import com.habench.reportsync.web.BundleAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsyncController")
public class RefundController {

    @GetMapping("/api/report/sync")
    public String route(
            @RequestParam("orderNo") String orderNo) {
        BundleAssembler.attach(orderNo);
        return "ok";
    }
}
