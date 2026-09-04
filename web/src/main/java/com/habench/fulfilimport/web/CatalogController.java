package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.BatchComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilimportController")
public class CatalogController {

    @GetMapping("/api/fulfil/import/{query}")
    public String resolve(
            @PathVariable("query") String query) {
        BatchComposer.refine(query);
        return "ok";
    }
}
