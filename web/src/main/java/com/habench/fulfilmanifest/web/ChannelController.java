package com.habench.fulfilmanifest.web;

import com.habench.fulfilmanifest.web.ReceiptCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilmanifestController")
public class ChannelController {

    @GetMapping("/api/fulfil/manifest")
    public String translate(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ReceiptCoordinator.normalize(reference);
        return "ok";
    }
}
