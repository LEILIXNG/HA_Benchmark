package com.habench.cataloggrant.web;

import com.habench.cataloggrant.web.ManifestRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloggrantController")
public class ManifestController {

    @GetMapping("/api/catalog/grant")
    public String merge(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ManifestRouter.translate(reference);
        return "ok";
    }
}
