package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.web.RefundRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreconcileController")
public class VoucherController {

    @GetMapping("/api/pricing/reconcile")
    public String refine(
            @RequestParam("label") String label) {
        RefundRouter.reconcile(label);
        return "ok";
    }
}
