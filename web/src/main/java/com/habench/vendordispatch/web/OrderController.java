package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.ContractRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordispatchController")
public class OrderController {

    @GetMapping("/api/vendor/dispatch")
    public String refine(
            @RequestParam("orderNo") String orderNo) {
        ContractRouter.route(orderNo);
        return "ok";
    }
}
