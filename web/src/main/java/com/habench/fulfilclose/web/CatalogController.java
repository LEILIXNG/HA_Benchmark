package com.habench.fulfilclose.web;

import com.habench.fulfilclose.web.ChannelRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilcloseController")
public class CatalogController {

    @GetMapping("/api/fulfil/close/{orderNo}")
    public String attach(
            @PathVariable("orderNo") String orderNo) {
        ChannelRouter.normalize(orderNo);
        return "ok";
    }
}
