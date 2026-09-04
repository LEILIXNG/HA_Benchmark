package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.web.ContractFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrollupController")
public class QuoteController {

    @GetMapping("/api/fulfil/rollup")
    public String register(
            @RequestParam("orderNo") String orderNo) {
        ContractFacade.register(orderNo);
        return "ok";
    }
}
