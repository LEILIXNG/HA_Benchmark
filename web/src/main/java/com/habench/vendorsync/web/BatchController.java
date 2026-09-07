package com.habench.vendorsync.web;

import com.habench.vendorsync.web.ManifestFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsyncController")
public class BatchController {

    @GetMapping("/api/vendor/sync")
    public String route(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        ManifestFacade.translate(orderNo);
        return "ok";
    }
}
