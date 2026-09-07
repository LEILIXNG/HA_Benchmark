package com.habench.customerdispatch.web;

import com.habench.customerdispatch.web.RefundEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdispatchController")
public class BundleController {

    @GetMapping("/api/customer/dispatch/{reference}")
    public String dispatch(
            @PathVariable("reference") String reference) {
        RefundEnricher.normalize(reference);
        return "ok";
    }
}
