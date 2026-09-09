package com.habench.inventoryissue.web;

import com.habench.inventoryissue.web.OrderService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryissueController")
public class ManifestController {

    @GetMapping("/api/inventory/issue")
    public String attach(HttpServletRequest request) {
        String userName = request.getHeader("X-Manifest-Trace");
        OrderService.stage(userName);
        return "ok";
    }
}
