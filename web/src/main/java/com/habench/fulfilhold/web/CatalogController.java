package com.habench.fulfilhold.web;

import com.habench.fulfilhold.web.AccountFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilholdController")
public class CatalogController {

    @GetMapping("/api/fulfil/hold")
    public String dispatch(
            @RequestParam("token") String token) {
        AccountFacade.register(token);
        return "ok";
    }
}
