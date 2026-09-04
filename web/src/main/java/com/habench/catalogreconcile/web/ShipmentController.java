package com.habench.catalogreconcile.web;

import com.habench.catalogreconcile.web.QuoteFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreconcileController")
public class ShipmentController {

    @GetMapping("/api/catalog/reconcile")
    public String forward(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        QuoteFacade.resolve(resource);
        return "ok";
    }
}
