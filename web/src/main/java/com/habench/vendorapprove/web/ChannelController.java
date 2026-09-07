package com.habench.vendorapprove.web;

import com.habench.vendorapprove.web.LedgerTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorapproveController")
public class ChannelController {

    @GetMapping("/api/vendor/approve")
    public String reconcile(
            @RequestParam("label") String label) {
        LedgerTranslator.translate(label);
        return "ok";
    }
}
