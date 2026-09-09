package com.habench.fulfillookup.web;

import com.habench.fulfillookup.web.BundleCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfillookupController")
public class PaymentController {

    @GetMapping("/api/fulfil/lookup")
    public String submit(HttpServletRequest request) {
        String filename = request.getHeader("X-Payment-Reference");
        BundleCoordinator.resolve(filename);
        return "ok";
    }
}
