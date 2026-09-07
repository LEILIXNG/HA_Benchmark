package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.web.ChannelAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsettlequeueController")
public class CatalogController {

    @GetMapping("/api/pricing/settlequeue")
    public String collect(
            @RequestParam("keyword") String keyword) {
        ChannelAdapter.refine(keyword);
        return "ok";
    }
}
