package com.habench.shippingtransfer.web;

import com.habench.shippingtransfer.web.BundleResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingtransferController")
public class TariffController {

    @GetMapping("/api/shipping/transfer")
    public String dispatch(
            @RequestParam("resource") String resource) {
        BundleResolver.refine(resource);
        return "ok";
    }
}
