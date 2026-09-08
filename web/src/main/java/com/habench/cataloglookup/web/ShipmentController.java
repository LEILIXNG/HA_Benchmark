package com.habench.cataloglookup.web;

import com.habench.cataloglookup.web.VoucherAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloglookupController")
public class ShipmentController {

    @GetMapping("/api/catalog/lookup")
    public String stage(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        VoucherAssembler.submit(category);
        return "ok";
    }
}
