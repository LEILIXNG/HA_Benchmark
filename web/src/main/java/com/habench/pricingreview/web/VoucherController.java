package com.habench.pricingreview.web;

import com.habench.pricingreview.web.ContractNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreviewController")
public class VoucherController {

    @GetMapping("/api/pricing/review/{filename}")
    public String compose(
            @PathVariable("filename") String filename) {
        ContractNormalizer.enrich(filename);
        return "ok";
    }
}
