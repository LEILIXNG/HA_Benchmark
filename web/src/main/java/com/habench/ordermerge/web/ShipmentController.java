package com.habench.ordermerge.web;

import com.habench.ordermerge.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordermergeController")
public class ShipmentController {

    @GetMapping("/api/order/merge/{target}")
    public String register(
            @PathVariable("target") String target) {
        BatchAdapter.expand(target);
        return "ok";
    }
}
