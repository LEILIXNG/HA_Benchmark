package com.habench.shippingsettle.web;

import com.habench.shippingsettle.web.VoucherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsettleController")
public class TariffController {

    @GetMapping("/api/shipping/settle")
    public String refine(
            @RequestParam("target") String target) {
        VoucherService.normalize(target);
        return "ok";
    }
}
