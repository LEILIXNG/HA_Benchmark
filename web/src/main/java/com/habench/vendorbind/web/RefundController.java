package com.habench.vendorbind.web;

import com.habench.vendorbind.web.TariffEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorbindController")
public class RefundController {

    @GetMapping("/api/vendor/bind")
    public String refine(
            @RequestParam("filename") String filename) {
        TariffEnricher.translate(filename);
        return "ok";
    }
}
