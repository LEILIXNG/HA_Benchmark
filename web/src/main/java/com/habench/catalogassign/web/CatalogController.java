package com.habench.catalogassign.web;

import com.habench.catalogassign.web.QuoteRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogassignController")
public class CatalogController {

    @GetMapping("/api/catalog/assign")
    public String forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Catalog-Tenant");
        QuoteRegistry.reconcile(reference);
        return "ok";
    }
}
