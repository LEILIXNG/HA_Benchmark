package com.habench.reportadjust.web;

import com.habench.reportadjust.web.TariffTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportadjustController")
public class ContractController {

    @GetMapping("/api/report/adjust")
    public String enrich(
            @RequestHeader("X-Contract-Client") String keyword) {
        TariffTranslator.attach(keyword);
        return "ok";
    }
}
