package com.habench.customerdigest.web;

import com.habench.customerdigest.web.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdigestController")
public class BatchController {

    @GetMapping("/api/customer/digest/{target}")
    public String route(
            @PathVariable("target") String target) {
        CatalogService.expand(target);
        return "ok";
    }
}
