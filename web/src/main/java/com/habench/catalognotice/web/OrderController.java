package com.habench.catalognotice.web;

import com.habench.catalognotice.web.CatalogResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalognoticeController")
public class OrderController {

    @GetMapping("/api/catalog/notice")
    public String compose(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        CatalogResolver.enrich(target);
        return "ok";
    }
}
