package com.habench.catalogbatch.web;

import com.habench.catalogbatch.web.ChannelBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogbatchController")
public class AccountController {

    @GetMapping("/api/catalog/batch")
    public String publish(
            @RequestParam("category") String category) {
        ChannelBroker.resolve(category);
        return "ok";
    }
}
