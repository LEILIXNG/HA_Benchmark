package com.habench.billingreopen.web;

import com.habench.billingreopen.web.VoucherAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreopenController")
public class ChannelController {

    @GetMapping("/api/billing/reopen/{category}")
    public String dispatch(
            @PathVariable("category") String category) {
        VoucherAssembler.collect(category);
        return "ok";
    }
}
