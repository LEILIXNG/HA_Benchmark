package com.habench.reportclose.web;

import com.habench.reportclose.web.VoucherRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportcloseController")
public class RefundController {

    @GetMapping("/api/report/close/{reference}")
    public String stage(
            @PathVariable("reference") String reference) {
        VoucherRegistry.dispatch(reference);
        return "ok";
    }
}
