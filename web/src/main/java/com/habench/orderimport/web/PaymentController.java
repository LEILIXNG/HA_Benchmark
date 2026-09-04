package com.habench.orderimport.web;

import com.habench.orderimport.web.TariffRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderimportController")
public class PaymentController {

    @GetMapping("/api/order/import/{tag}")
    public String compose(
            @PathVariable("tag") String tag) {
        TariffRouter.enrich(tag);
        return "ok";
    }
}
