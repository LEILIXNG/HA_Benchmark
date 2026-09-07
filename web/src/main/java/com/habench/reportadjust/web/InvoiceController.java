package com.habench.reportadjust.web;

import com.habench.reportadjust.web.BundleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportadjustController")
public class InvoiceController {

    @GetMapping("/api/report/adjust")
    public String compose(
            @RequestParam("tag") String tag) {
        BundleService.submit(tag);
        return "ok";
    }
}
