package com.habench.customeradjust.web;

import com.habench.customeradjust.web.VoucherComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customeradjustController")
public class BundleController {

    @GetMapping("/api/customer/adjust/{label}")
    public String refine(
            @PathVariable("label") String label) {
        VoucherComposer.translate(label);
        return "ok";
    }
}
