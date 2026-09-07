package com.habench.customerarchive.web;

import com.habench.customerarchive.web.CatalogAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerarchiveController")
public class ShipmentController {

    @GetMapping("/api/customer/archive")
    public String dispatch(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        CatalogAdapter.assemble(userName);
        return "ok";
    }
}
