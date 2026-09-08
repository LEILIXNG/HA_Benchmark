package com.habench.vendormerge.web;

import com.habench.vendormerge.web.ShipmentBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendormergeController")
public class CatalogController {

    @GetMapping("/api/vendor/merge")
    public String compose(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        ShipmentBuilder.dispatch(query);
        return "ok";
    }
}
