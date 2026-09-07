package com.habench.catalogreopen.web;

import com.habench.catalogreopen.web.CatalogCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreopenController")
public class OrderController {

    @GetMapping("/api/catalog/reopen/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        CatalogCoordinator.forward(userName);
        return "ok";
    }
}
