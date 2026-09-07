package com.habench.customerexport.web;

import com.habench.customerexport.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerexportController")
public class VoucherController {

    @GetMapping("/api/customer/export/{reference}")
    public String refine(
            @PathVariable("reference") String reference) {
        ManifestNormalizer.forward(reference);
        return "ok";
    }
}
