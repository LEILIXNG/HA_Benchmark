package com.habench.vendorquote.web;

import com.habench.vendorquote.web.CatalogRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorquoteController")
public class VoucherController {

    @GetMapping("/api/vendor/quote/{reference}")
    public String refine(
            @PathVariable("reference") String reference) {
        CatalogRouter.forward(reference);
        return "ok";
    }
}
