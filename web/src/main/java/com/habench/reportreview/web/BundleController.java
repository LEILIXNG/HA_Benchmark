package com.habench.reportreview.web;

import com.habench.reportreview.web.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportreviewController")
public class BundleController {

    @GetMapping("/api/report/review")
    public String prepare(
            @RequestParam("query") String query) {
        InvoiceService.prepare(query);
        return "ok";
    }
}
