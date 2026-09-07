package com.habench.fulfilhold.web;

import com.habench.fulfilhold.web.AccountBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilholdController")
public class CatalogController {

    @GetMapping("/api/fulfil/hold")
    public String submit(
            @RequestParam("orderNo") String orderNo) {
        AccountBroker.expand(orderNo);
        return "ok";
    }
}
