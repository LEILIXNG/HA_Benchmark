package com.habench.fulfilsettlequeue.web;

import com.habench.fulfilsettlequeue.web.ManifestService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsettlequeueController")
public class CatalogController {

    @GetMapping("/api/fulfil/settlequeue")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Catalog-Reference");
        ManifestService.assemble(keyword);
        return "ok";
    }
}
