package com.habench.catalogassign.web;

import com.habench.catalogassign.web.ChannelAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogassignController")
public class CatalogController {

    @GetMapping("/api/catalog/assign")
    public String dispatch(
            @RequestParam("resource") String resource) {
        ChannelAdapter.reconcile(resource);
        return "ok";
    }
}
