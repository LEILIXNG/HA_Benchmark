package com.habench.customersettlequeue.web;

import com.habench.customersettlequeue.web.LedgerCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersettlequeueController")
public class RefundController {

    @GetMapping("/api/customer/settlequeue/{userName}")
    public String refine(
            @PathVariable("userName") String userName) {
        LedgerCoordinator.assemble(userName);
        return "ok";
    }
}
