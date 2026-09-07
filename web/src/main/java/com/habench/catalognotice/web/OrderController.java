package com.habench.catalognotice.web;

import com.habench.catalognotice.web.CatalogResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalognoticeController")
public class OrderController {

    @GetMapping("/api/catalog/notice/{query}")
    public String compose(
            @PathVariable("query") String query) {
        CatalogResolver.enrich(query);
        return "ok";
    }
}
