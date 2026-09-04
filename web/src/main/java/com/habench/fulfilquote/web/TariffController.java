package com.habench.fulfilquote.web;

import com.habench.fulfilquote.web.RefundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilquoteController")
public class TariffController {

    @GetMapping("/api/fulfil/quote")
    public String resolve(
            @RequestParam("orderNo") String orderNo) {
        RefundService.attach(orderNo);
        return "ok";
    }
}
