package com.habench.fulfilsettle.web;

import com.habench.fulfilsettle.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsettleController")
public class OrderController {

    @GetMapping("/api/fulfil/settle/{userName}")
    public String submit(
            @PathVariable("userName") String userName) {
        CatalogFacade.attach(userName);
        return "ok";
    }
}
