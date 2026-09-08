package com.habench.customersettle.web;

import com.habench.customersettle.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersettleController")
public class ShipmentController {

    @GetMapping("/api/customer/settle/{target}")
    public String register(
            @PathVariable("target") String target) {
        BatchAdapter.expand(target);
        return "ok";
    }
}
