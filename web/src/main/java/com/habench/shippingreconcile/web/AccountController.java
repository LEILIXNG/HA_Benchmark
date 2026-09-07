package com.habench.shippingreconcile.web;

import com.habench.shippingreconcile.web.ContractAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreconcileController")
public class AccountController {

    @GetMapping("/api/shipping/reconcile/{filename}")
    public String resolve(
            @PathVariable("filename") String filename) {
        ContractAdapter.collect(filename);
        return "ok";
    }
}
