package com.habench.fulfilclose.web;

import com.habench.fulfilclose.web.ChannelRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilcloseController")
public class CatalogController {

    @GetMapping("/api/fulfil/close")
    public String resolve(
            @RequestParam("reference") String reference) {
        ChannelRouter.collect(reference);
        return "ok";
    }
}
