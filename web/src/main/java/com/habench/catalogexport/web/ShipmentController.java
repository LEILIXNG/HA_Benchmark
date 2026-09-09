package com.habench.catalogexport.web;

import com.habench.catalogexport.web.ChannelAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogexportController")
public class ShipmentController {

    @GetMapping("/api/catalog/export")
    public String forward(HttpServletRequest request) {
        String token = request.getHeader("X-Shipment-Tenant");
        ChannelAdapter.normalize(token);
        return "ok";
    }
}
