package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilnoticeController")
public class RefundController {

    @GetMapping("/api/fulfil/notice/{orderNo}")
    public String reconcile(
            @PathVariable("orderNo") String orderNo) {
        CatalogCollector.route(orderNo);
        return "ok";
    }
}
