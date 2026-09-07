package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.RefundFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryimportController")
public class RefundController {

    @GetMapping("/api/inventory/import")
    public String merge(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        RefundFacade.refine(filename);
        return "ok";
    }
}
