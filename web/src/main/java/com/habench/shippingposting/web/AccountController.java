package com.habench.shippingposting.web;

import com.habench.shippingposting.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingpostingController")
public class AccountController {

    @GetMapping("/api/shipping/posting")
    public String resolve(
            @RequestHeader("X-Account-Reference") String userName) {
        CatalogFacade.forward(userName);
        return "ok";
    }
}
