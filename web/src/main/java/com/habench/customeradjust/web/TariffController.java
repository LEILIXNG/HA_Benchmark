package com.habench.customeradjust.web;

import com.habench.customeradjust.web.ChannelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("customeradjustController")
public class TariffController {

    @GetMapping("/api/customer/adjust")
    public String dispatch(
            @RequestHeader("X-Tariff-Context") String tag) {
        ChannelService.submit(tag);
        return "ok";
    }
}
