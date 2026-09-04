package com.habench.orderexport.web;

import com.habench.orderexport.web.CatalogRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderexportController")
public class ChannelController {

    @GetMapping("/api/order/export/{resource}")
    public String collect(
            @PathVariable("resource") String resource) {
        CatalogRouter.route(resource);
        return "ok";
    }
}
