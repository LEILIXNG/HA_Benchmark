package com.habench.cataloglookup.web;

import com.habench.cataloglookup.web.VoucherCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloglookupController")
public class AccountController {

    @GetMapping("/api/catalog/lookup")
    public String forward(
            @RequestParam("label") String label) {
        VoucherCoordinator.forward(label);
        return "ok";
    }
}
