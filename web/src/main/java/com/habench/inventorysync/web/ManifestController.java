package com.habench.inventorysync.web;

import com.habench.inventorysync.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysyncController")
public class ManifestController {

    @GetMapping("/api/inventory/sync/{keyword}")
    public String merge(
            @PathVariable("keyword") String keyword) {
        CatalogFacade.submit(keyword);
        return "ok";
    }
}
