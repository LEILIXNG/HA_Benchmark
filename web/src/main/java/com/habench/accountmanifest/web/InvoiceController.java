package com.habench.accountmanifest.web;

import com.habench.accountmanifest.web.ManifestAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountmanifestController")
public class InvoiceController {

    @GetMapping("/api/account/manifest")
    public String merge(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ManifestAssembler.publish(category);
        return "ok";
    }
}
