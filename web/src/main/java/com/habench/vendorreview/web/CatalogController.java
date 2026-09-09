package com.habench.vendorreview.web;

import com.habench.vendorreview.web.ReceiptService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreviewController")
public class CatalogController {

    @GetMapping("/api/vendor/review")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Catalog-Tenant");
        ReceiptService.submit(category);
        return "ok";
    }
}
