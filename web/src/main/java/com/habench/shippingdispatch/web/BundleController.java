package com.habench.shippingdispatch.web;

import com.habench.shippingdispatch.web.QuoteTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingdispatchController")
public class BundleController {

    @GetMapping("/api/shipping/dispatch")
    public String dispatch(
            @RequestParam("orderNo") String orderNo) {
        QuoteTranslator.publish(orderNo);
        return "ok";
    }
}
