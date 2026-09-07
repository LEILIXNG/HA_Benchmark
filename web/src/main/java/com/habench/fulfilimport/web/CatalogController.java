package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.OrderBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilimportController")
public class CatalogController {

    @GetMapping("/api/fulfil/import/{orderNo}")
    public String collect(
            @PathVariable("orderNo") String orderNo) {
        OrderBroker.compose(orderNo);
        return "ok";
    }
}
