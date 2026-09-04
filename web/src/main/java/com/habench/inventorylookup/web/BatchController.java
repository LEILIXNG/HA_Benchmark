package com.habench.inventorylookup.web;

import com.habench.inventorylookup.web.VoucherCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorylookupController")
public class BatchController {

    @GetMapping("/api/inventory/lookup/{userName}")
    public String reconcile(
            @PathVariable("userName") String userName) {
        VoucherCoordinator.translate(userName);
        return "ok";
    }
}
