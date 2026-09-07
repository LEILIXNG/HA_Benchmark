package com.habench.fulfilbind.web;

import com.habench.fulfilbind.web.RefundComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilbindController")
public class CatalogController {

    @GetMapping("/api/fulfil/bind/{orderNo}")
    public String stage(
            @PathVariable("orderNo") String orderNo) {
        RefundComposer.prepare(orderNo);
        return "ok";
    }
}
