package com.habench.reportcapture.web;

import com.habench.reportcapture.web.OrderRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportcaptureController")
public class VoucherController {

    @GetMapping("/api/report/capture")
    public String assemble(
            @RequestParam("keyword") String keyword) {
        OrderRegistry.publish(keyword);
        return "ok";
    }
}
