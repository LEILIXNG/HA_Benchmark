package com.habench.accountsplit.web;

import com.habench.accountsplit.web.RefundCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsplitController")
public class ShipmentController {

    @GetMapping("/api/account/split")
    public String register(
            @RequestParam("filename") String filename) {
        RefundCoordinator.stage(filename);
        return "ok";
    }
}
