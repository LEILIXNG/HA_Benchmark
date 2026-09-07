package com.habench.fulfilsettle.web;

import com.habench.fulfilsettle.web.RefundTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsettleController")
public class CatalogController {

    @GetMapping("/api/fulfil/settle/{keyword}")
    public String attach(
            @PathVariable("keyword") String keyword) {
        RefundTranslator.register(keyword);
        return "ok";
    }
}
