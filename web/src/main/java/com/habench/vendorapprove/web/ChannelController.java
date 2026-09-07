package com.habench.vendorapprove.web;

import com.habench.vendorapprove.web.CatalogTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorapproveController")
public class ChannelController {

    @GetMapping("/api/vendor/approve/{orderNo}")
    public String translate(
            @PathVariable("orderNo") String orderNo) {
        CatalogTranslator.dispatch(orderNo);
        return "ok";
    }
}
