package com.habench.orderimport.web;

import com.habench.orderimport.web.ChannelComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderimportController")
public class ContractController {

    @GetMapping("/api/order/import")
    public String assemble(
            @RequestParam("resource") String resource) {
        ChannelComposer.collect(resource);
        return "ok";
    }
}
