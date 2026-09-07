package com.habench.shippingsettle.web;

import com.habench.shippingsettle.web.BundleNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsettleController")
public class TariffController {

    @GetMapping("/api/shipping/settle/{resource}")
    public String dispatch(
            @PathVariable("resource") String resource) {
        BundleNormalizer.submit(resource);
        return "ok";
    }
}
