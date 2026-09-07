package com.habench.reportreopen.web;

import com.habench.reportreopen.web.BundleBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportreopenController")
public class VoucherController {

    @GetMapping("/api/report/reopen/{category}")
    public String collect(
            @PathVariable("category") String category) {
        BundleBuilder.publish(category);
        return "ok";
    }
}
