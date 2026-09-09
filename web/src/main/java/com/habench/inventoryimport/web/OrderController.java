package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.BundleEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryimportController")
public class OrderController {

    @GetMapping("/api/inventory/import")
    public String dispatch(HttpServletRequest request) {
        String tag = request.getHeader("X-Order-Client");
        BundleEnricher.translate(tag);
        return "ok";
    }
}
