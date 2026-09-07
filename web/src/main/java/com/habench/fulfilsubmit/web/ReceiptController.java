package com.habench.fulfilsubmit.web;

import com.habench.fulfilsubmit.web.VoucherRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsubmitController")
public class ReceiptController {

    @GetMapping("/api/fulfil/submit/{userName}")
    public String collect(
            @PathVariable("userName") String userName) {
        VoucherRegistry.publish(userName);
        return "ok";
    }
}
