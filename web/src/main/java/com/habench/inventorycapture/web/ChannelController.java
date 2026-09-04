package com.habench.inventorycapture.web;

import com.habench.inventorycapture.web.TariffTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorycaptureController")
public class ChannelController {

    @GetMapping("/api/inventory/capture")
    public String forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        TariffTranslator.refine(reference);
        return "ok";
    }
}
