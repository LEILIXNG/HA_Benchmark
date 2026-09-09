package com.habench.fulfilcapture.web;

import com.habench.fulfilcapture.web.InvoiceComposer;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilcaptureController")
public class TariffController {

    @GetMapping("/api/fulfil/capture")
    public String compose(
            @CookieValue("tariff_ref") String reference) {
        InvoiceComposer.translate(reference);
        return "ok";
    }
}
