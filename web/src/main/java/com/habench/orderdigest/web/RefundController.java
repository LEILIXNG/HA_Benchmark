package com.habench.orderdigest.web;

import com.habench.orderdigest.web.ChannelComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderdigestController")
public class RefundController {

    @GetMapping("/api/order/digest")
    public String assemble(
            @RequestParam("reference") String reference) {
        ChannelComposer.prepare(reference);
        return "ok";
    }
}
