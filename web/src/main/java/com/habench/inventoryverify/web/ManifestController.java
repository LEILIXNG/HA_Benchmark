package com.habench.inventoryverify.web;

import com.habench.inventoryverify.web.OrderBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryverifyController")
public class ManifestController {

    @GetMapping("/api/inventory/verify")
    public String stage(HttpServletRequest request) {
        String reference = request.getHeader("X-Manifest-Context");
        OrderBuilder.refine(reference);
        return "ok";
    }
}
