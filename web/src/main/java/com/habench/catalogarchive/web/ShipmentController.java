package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.BundleFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogarchiveController")
public class ShipmentController {

    @GetMapping("/api/catalog/archive")
    public String refine(HttpServletRequest request) {
        String tag = request.getHeader("X-Shipment-Context");
        BundleFacade.collect(tag);
        return "ok";
    }
}
