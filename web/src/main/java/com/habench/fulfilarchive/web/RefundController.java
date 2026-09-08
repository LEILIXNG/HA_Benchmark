package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.web.TariffFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilarchiveController")
public class RefundController {

    @GetMapping("/api/fulfil/archive")
    public String register(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        TariffFacade.translate(category);
        return "ok";
    }
}
