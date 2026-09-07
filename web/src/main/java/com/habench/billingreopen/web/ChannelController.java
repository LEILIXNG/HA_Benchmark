package com.habench.billingreopen.web;

import com.habench.billingreopen.web.VoucherCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreopenController")
public class ChannelController {

    @GetMapping("/api/billing/reopen")
    public String assemble(
            @RequestParam("query") String query) {
        VoucherCoordinator.enrich(query);
        return "ok";
    }
}
