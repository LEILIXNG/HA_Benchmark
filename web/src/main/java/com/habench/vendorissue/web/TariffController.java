package com.habench.vendorissue.web;

import com.habench.vendorissue.web.PaymentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorissueController")
public class TariffController {

    @GetMapping("/api/vendor/issue")
    public String publish(
            @RequestParam("keyword") String keyword) {
        PaymentBuilder.submit(keyword);
        return "ok";
    }
}
