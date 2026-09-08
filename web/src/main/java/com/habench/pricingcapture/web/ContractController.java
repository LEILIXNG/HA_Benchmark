package com.habench.pricingcapture.web;

import com.habench.pricingcapture.web.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingcaptureController")
public class ContractController {

    @GetMapping("/api/pricing/capture")
    public String route(
            @RequestParam("filename") String filename) {
        SessionService.resolve(filename);
        return "ok";
    }
}
