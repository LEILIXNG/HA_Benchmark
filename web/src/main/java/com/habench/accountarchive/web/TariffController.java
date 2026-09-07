package com.habench.accountarchive.web;

import com.habench.accountarchive.web.ShipmentBroker2;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountarchiveController")
public class TariffController {

    @GetMapping("/api/account/archive")
    public String collect(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ShipmentBroker2.expand(category);
        return "ok";
    }
}
