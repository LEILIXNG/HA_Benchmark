package com.habench.inventoryreconcile.web;

import com.habench.inventoryreconcile.web.BatchBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreconcileController")
public class ManifestController {

    @GetMapping("/api/inventory/reconcile")
    public String expand(HttpServletRequest request) {
        String filename = request.getHeader("X-Manifest-Channel");
        BatchBuilder.normalize(filename);
        return "ok";
    }
}
